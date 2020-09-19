package com.xiechy.wx.service.impl;

import cn.ardy.lottery.connector.session.RedisService;
import cn.ardy.lottery.core.bean.User;
import cn.ardy.lottery.core.bean.vo.FansVo;
import cn.ardy.lottery.core.repository.UserRepository;
import cn.ardy.lottery.core.service.UserService;
import cn.ardy.lottery.core.service.impl.WxFansService;
import cn.ardy.lottery.gateway.h5.bean.WxJsConfig;
import cn.ardy.lottery.gateway.h5.service.WxUserService;
import cn.ardy.lottery.pay.wxpay.JsApiSignUtil;
import cn.ardy.lottery.pay.wxpay.WXPayConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WxUserServiceImpl implements WxUserService {
    private static final int ConTimeOut = 1000 * 2;
    private static final int RedTimeOut = 1000 * 2;

    //    //TODO for test
//    private static String ACCESS_TOKEN = "17_uNtnbPdp3uJB07YSqLyxvNJ_UK4oYnKLw23ao3p-3UA2R0gH3Pk0o83Y_8FB-USPp4NGYgf9MpqTKhvhngvzEIXdaz5Q4-TuBSWtXUXplWkfRZWRhQUnq4_NsXNOp7OmO3-9PBCyfu-hET-CVJDcABAGUO";
//    private static Date EXPIRES_DATE = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2);
    private static String ACCESS_TOKEN;
    private static Date EXPIRES_DATE = new Date();

    @Value("${wx.pm.appid}")
    private String APPID;
    @Value("${wx.pm.key}")
    private String SECRET;
    /**
     * 根据用户授权code，换取用户openId和用户授权accessToken
     * appid、secret、code
     **/
    private static final String AUTH = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
            "appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * 获取微信应用授权token，应用内共用
     * appid 、secret
     */
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * 获取微信JSapi ticket,参数（应用的，非用户信息授权token）：access_token
     * https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=16_0GPZpSxuOHEBrxCoWlGl-2tgZHJLp3U_MtIIz9ESySFd38rxc1bFYY1PXWIbVHXBlpVQZxWT7jY2aogQawjcLg&type=jsapi
     **/
    private static final String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

    /****
     * 获取微信用户基本信息
     * 1 accessToken ;2 openId
     */
    private static final String WX_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    @Autowired
    private WxFansService fansService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    public User getUser(String code) throws Exception {
        if (code == null) {
            log.warn("授权获取微信用户信息，code为空!");
            return null;
        }
        String url = String.format(AUTH, APPID, SECRET, code);
        log.info("请求微信授权URL:" + url);
        String request = this.httpRequest(url, ConTimeOut, RedTimeOut);
        log.info("get wx response:" + request);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = mapper.readValue(request, new TypeReference<HashMap<String, String>>() {
        });
        final String uid = map.get("openid");
        if (uid == null || uid.length() < 1) {
            log.error("获取微信授权失败!" + map);
            throw new Exception("获取微信授权失败!");
        }
        User user = userService.findUserByUid(uid);
        if (user == null) {
            user = this.getWxUser(map.get("access_token"), map.get("openid"));
            userService.addUser(user);
        }
        return user;
    }

    /**
     * 获取accessToken
     *
     * @return
     */
    public String getAccessToken() throws Exception {
        if (ACCESS_TOKEN != null && new Date().before(EXPIRES_DATE)) {
            return ACCESS_TOKEN;
        }
        String url = String.format(ACCESS_TOKEN_URL, APPID, SECRET);
        log.info("获取应用accessToken url:" + url);
        String request = this.httpRequest(url, ConTimeOut, RedTimeOut);
        log.info("get wx accessToken response:" + request);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = mapper.readValue(request, new TypeReference<HashMap<String, String>>() {
        });
        String accessToken = map.get("access_token");
        String expiresIn = map.get("expires_in");
        if (accessToken == null) {
            throw new Exception("获取accesstoken 失败！");
        }
        ACCESS_TOKEN = accessToken;
        //提前一分钟获取新token
        EXPIRES_DATE = new Date(System.currentTimeMillis() + Long.valueOf(expiresIn) * 1000 - 1000 * 60);
        return ACCESS_TOKEN;
    }

    public WxJsConfig getJsapiTicket(String url) throws Exception {
        String request = this.httpRequest(String.format(JSAPI_TICKET, getAccessToken()), ConTimeOut, RedTimeOut);

        log.info("get wx response:" + request);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = mapper.readValue(request, new TypeReference<HashMap<String, String>>() {
        });
        String ticket = map.get("ticket");
        if (ticket == null) {
            log.error("获取JsApiTicket 出错！返回结果：" + request);
            throw new Exception("获取JsApiTicket 出错！");
        }
        Map<String, String> stringMap = JsApiSignUtil.sign(ticket, url);
        WxJsConfig config = new WxJsConfig()
                .setAppId(this.APPID)
                .setDebug(Boolean.TRUE)
                .setNonceStr(stringMap.get("nonceStr"))
                .setSignature(stringMap.get("signature"))
                .setTimestamp(Long.valueOf(stringMap.get("timestamp")));
        return config;
    }

    private User getWxUser(String accessToken, String openId) throws Exception {
        String url = String.format(WX_USER_INFO, accessToken, openId);
        log.info("请求微信授权URL:" + url);
        String request = this.httpRequest(url, ConTimeOut, RedTimeOut);
        log.info("get wx response:" + request);
        ObjectMapper mapper = new ObjectMapper();
        WxUserInfo wu = mapper.readValue(request, WxUserInfo.class);
        User user = User.builder()
                .userName(wu.nickname)
                .uid(openId)
                .channel("WX")
                .province(wu.province)
                .city(wu.city)
                .img(wu.headimgurl)
                .sex(wu.sex).build();

        return user;
    }

    /**
     * http 请求
     *
     * @param url
     * @param connectTimeoutMs
     * @param readTimeoutMs
     * @return
     * @throws Exception
     */
    private String httpRequest(String url, int connectTimeoutMs, int readTimeoutMs) throws Exception {
        BasicHttpClientConnectionManager connManager;
        connManager = new BasicHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
                        .build(),
                null,
                null,
                null
        );
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeoutMs).setConnectTimeout(connectTimeoutMs).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", WXPayConstants.USER_AGENT);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    static class WxUserInfo {
        private String openid;
        private String nickname;
        private Integer sex;
        private String province;
        private String city;
        private String headimgurl;
        private String unionid;
    }


    @Async
    @Override
    public User syncFansInfo() {
        try {
            String accessToken = getAccessToken();
            Object nextOpenId = redisService.getValue("next_openid");
            FansVo vo = fansService.getFansListUrl(accessToken, (String) nextOpenId);

            if (null == vo.errcode && vo.count != 0) {
                vo.data.forEach(i -> {
                    List<User> userList = userRepository.findAllByUid(i.toString());
                    User use = new User();
                    if (!CollectionUtils.isEmpty(userList)) {
                        use = userList.get(0);
                    }
                    User info = WxFansService.getMoreInfo(use,accessToken, i.toString());
                    userRepository.saveAndFlush(info);
                });
            } else {
                if ( vo.count == 0) {
                    vo.errmsg = "无最同步新信息";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}


