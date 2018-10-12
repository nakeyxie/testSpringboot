package com.xiechy.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiechy.testBeanutils.Person;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiechy
 * @create 2018-03-20
 * @Descrption
 **/
public class ExperimentPackServiceTest {

    @Test
    public void testGetItem() throws IOException {
        HttpClient client = new HttpClient();
        String url = "http://localhost:8888/bosslab/experimentPack/getDetectionGroup";
        //PostMethod post = new PostMethod(url);
        GetMethod post = new GetMethod(url);
        int resultCode = client.executeMethod(post);
        if (HttpStatus.SC_OK == resultCode) {
            byte[] result = post.getResponseBody();
            String resultStr = new String(result, "UTF-8");
            System.out.println("结果为：");
            System.out.println(resultStr);
        }

    }

    public void parse(){
        /**
         * json字符串转化为对象
         */
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        Person person = JSON.parseObject(jsonString, Person.class);
        System.out.println(person.toString());

        /**
         * 对象转化为json字符串
         */
        String jsonStr = JSON.toJSONString(person);
        System.out.println(jsonStr);
    }

    public void testHttp(){

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("key1","value1");
        paramsMap.put("key2","value2");
        paramsMap.put("key3","value3");
        HttpClient httpclient = new HttpClient();//https://api.mch.weixin.qq.com/pay/unifiedorder
        String url = "http://127.0.0.1:8088/H-web/product/test1.htm";
        PostMethod post = new PostMethod(url);
        String info = null;
        try {
            RequestEntity entity = new StringRequestEntity(JSON.toJSONString(paramsMap), "text/xml","UTF-8");
            post.setRequestEntity(entity);
            httpclient.executeMethod(post);
            int code = post.getStatusCode();
            if (code == HttpStatus.SC_OK){
                byte[] responseBody = post.getResponseBody();
                info = new String(responseBody, "UTF-8");
                JSONArray jsoin = JSONArray.parseArray(info);
                List<Object> list = (List<Object>) JSONArray.toJSON(jsoin);
                System.out.println("=========="+list+"++++++++++");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            post.releaseConnection();
        }
    }

    @Test
    public void testMap2Json(){
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("key1","value1");
        paramsMap.put("key2","value2");
        paramsMap.put("key3","value3");
        System.out.println(JSON.toJSONString(paramsMap));
    }

    @Test
    public void testGetHoliday(){
        HttpClient client = new HttpClient();
        String date ="20180930";
        String url = "http://api.goseek.cn/Tools/holiday?date="+date;
        GetMethod getMethod = new GetMethod(url);

        try {
            int resultCode = client.executeMethod(getMethod);
            if (HttpStatus.SC_OK == resultCode) {
                byte[] result = getMethod.getResponseBody();
                String resultStr = new String(result, "UTF-8");
                System.out.println("结果为：");
                System.out.println(resultStr);
                JSONObject object = JSONObject.parseObject(resultStr);
                Integer number = (Integer) object.get("data");
                System.out.println(number.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




    
        