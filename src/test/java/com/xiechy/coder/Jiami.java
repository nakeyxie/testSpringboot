package com.xiechy.coder;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.common.util.SignUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.bouncycastle.jcajce.provider.asymmetric.util.DESUtil;

/**
 * @ClassName Jiami
 * @Description 加密实例代码
 * @Author xcy
 * @Date 2021/4/27 10:09
 */
public class Jiami {

    public JSONObject sendHttpPostWithJson(String url, String json, String companyStr, String privateKey) throws Exception {
        // MD5摘要
        String signMd5 = DigestUtils.md5Hex(json.toString().getBytes("UTF-8")).toUpperCase();
        System.out.println("签名原串:" + json.toString() + " ；签名结果：" + signMd5);
        // 平台私钥签名
        String signRSA = null;
        //String signRSA = SignUtils.Signaturer(signMd5, privateKey);

        // 生成临时安全密钥
        String safeKey ="232432";
        // DES加密
        String encrypt = null;
        //String encrypt = DESUtil.encrypt(json, safeKey);

        // 公钥加密DES秘钥
        String privateKeyEncrypt = null;
        //String privateKeyEncrypt = RSAUtils.privateKeyEncrypt(privateKey, safeKey);

        // 发起请求;
        Header authentication = new BasicHeader("Authentication", signRSA);
        Header secutiryKey = new BasicHeader("SecutiryKey", privateKeyEncrypt);
        Header company = new BasicHeader("company", companyStr);

        Header[] headers = new Header[3];
        headers[0] = authentication;
        headers[1] = secutiryKey;
        headers[2] = company;

        String data = "{\"data\":\"" + encrypt + "\"}";
        data = JSONObject.parseObject(data).toString();
        String result = null;
        //String result = new HttpClientUtil().sendHttpPostWithJson(url, data, headers);
        JSONObject resultJson = null;
        if (StringUtils.isNotBlank(result)) {
            try {
                resultJson = JSONObject.parseObject(result);
                result = (String) resultJson.get("result");
                if (result != null && result != "") {
                    // DES解密
                    //result = DESUtil.decrypt(result, safeKey);
                    resultJson = JSONObject.parseObject(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        // 返回
        return resultJson;
    }
}
