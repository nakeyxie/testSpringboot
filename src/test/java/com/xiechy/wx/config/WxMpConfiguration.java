package com.xiechy.wx.config;

/*import cn.llc.activity.handler.wx.LogHandler;
import cn.llc.activity.handler.wx.SubscribeHandler;*/
import com.xiechy.wx.LogHandler;
import com.xiechy.wx.SubscribeHandler;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * wechat mp configuration
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@Configuration
public class WxMpConfiguration {
    @Value("${wx.pm.appid}")
    private String appid;
    @Value("${wx.pm.key}")
    private String secret;
    @Value("${wx.pm.token}")
    private String token;
    @Value("${wx.pm.aeskey}")
    private String aeskey;

    @Resource
    private SubscribeHandler subscribeHandler;
    @Resource
    private LogHandler logHandler;

    @Bean(name = "wxMpServerGithub")
    public WxMpService wxMpService() {
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(appid); // 设置微信公众号的appid
        config.setSecret(secret); // 设置微信公众号的app corpSecret
        /*config.setToken(token); // 设置微信公众号的token
        config.setAesKey(aeskey); // 设置微信公众号的EncodingAESKey*/
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(config);
        return wxMpService;
    }

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);
        // 记录所有事件的日志 （异步执行）
        newRouter.rule().handler(this.logHandler).next();
        //用户关注事件 同步返回
        newRouter.rule().async(false).msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.SUBSCRIBE).handler(this.subscribeHandler).end();
        // 取消关注事件
//        newRouter.rule().async(false).msgType(EVENT).event(UNSUBSCRIBE).handler(this.unsubscribeHandler).end();
        // 扫码事件
//        newRouter.rule().async(false).msgType(EVENT).event(EventType.SCAN).handler(this.scanHandler).end();
        // 默认
//        newRouter.rule().async(false).handler(this.msgHandler).end();

        return newRouter;
    }

}
