package com.xiechy.testHttp;


import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.NameValuePair;  
import org.apache.commons.httpclient.methods.PostMethod;  
  
public class testPost {  
    private void test(){          
        HttpClient client = new HttpClient();  
        String queryString = "{\"userId\":\"20130705144110|18963603541\",\"phoneName\":\"华为190\",\"phoneVersion\":\"v.1.1\",\"className\":\"SaveQuick\",\"type\":\"1\",\"queryMonth\":\"2013-02\",\"startTime\":\"2013-02-03 11:16\",\"endTime\":\"2013-02-03 14:16\"}";  
        PostMethod get = new PostMethod("http://localhost:8080/servlet/JsonServlet");  
          
        NameValuePair[] data = new NameValuePair[1];  
        NameValuePair nameValuePair1 = new NameValuePair("jsonStr", queryString);  
        //NameValuePair nameValuePair2 = new NameValuePair("docId", "42");  
        data[0]=nameValuePair1;  
        //data[1]=nameValuePair2;  
        get.setRequestBody(data);  
        System.out.println("para="+queryString);  
        String result = "";  
          
        try{  
            client.executeMethod(get);  
            //byte[] responseBody = get.getResponseBody();  
            StringBuffer sb = new StringBuffer();  
            sb.append(get.getResponseBody());  
            result = new String(get.getResponseBody(), "utf-8");  
            System.out.println("result="+result);  
        }catch (Exception e) {  
            // TODO: handle exception  
        }  
    }  
      
    public static void main(String[] args) {  
        testPost pt = new testPost();  
        pt.test();  
    }  
}  