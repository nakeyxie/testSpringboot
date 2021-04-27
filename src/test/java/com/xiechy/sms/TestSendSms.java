package com.xiechy.sms;

import com.alibaba.fastjson.JSON;
import com.xiechy.http.HttpUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestSendSms
 * @Description TODO
 * @Author xcy
 * @Date 2021/4/26 17:23
 */
public class TestSendSms {



    @Test
    public void tesetSendSmsCode(){

        String url ="http://api.xcy.*.com/asmx/smsxcyservice.*";
        Map<String,String> paramsMap = new HashMap<String,String>();
        paramsMap.put("name","*");
        paramsMap.put("pwd","*");
        paramsMap.put("mobile","899890");
        paramsMap.put("content","测试发送信息给你!");
        paramsMap.put("sign","testes");
        paramsMap.put("stime","");
        paramsMap.put("type","pt");
        paramsMap.put("extno","");
        String response = HttpUtils.URLPost(url,paramsMap,"UTF-8");
        System.out.println(response);
        URLEncoder.encode("123");

    }

   /* targeturl = URLEncoder.encode("http://*.*.com/service/ssoDispatch?projectid="+projectid+"&dispatchtype="+dispatchtype,"utf-8");
    targeturl = URLEncoder.encode(targeturl,"utf-8");*/
      //req.setCharacterEncoding("UTF-8"); 请求中带中文乱码，加上这句话就正常
      //response.setCharacterEncoding("UTF-8");

    //http://*.com/asmx/*.aspx?name=test&pwd=112345&content=testmsg&mobile=*,*&stime=2012-08-01 8:20:23&sign=testsign&type=&extno=

    @Test
    public void tesetSendSmsCode1(){
        HttpClient httpclient = new HttpClient();
        String url = "http://api.*.com/*/*.aspx" +
                "?name=*&pwd=*&content=testmsg&mobile=*&stime=&sign=&type=&extno=";
        PostMethod post = new PostMethod(url);
        String info = null;
        try {
            httpclient.executeMethod(post);
            int code = post.getStatusCode();
            if (code == HttpStatus.SC_OK){
                byte[] responseBody = post.getResponseBody();
                info = new String(responseBody, "UTF-8");
                System.out.println("返回结果："+info);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            post.releaseConnection();
        }
    }
}
