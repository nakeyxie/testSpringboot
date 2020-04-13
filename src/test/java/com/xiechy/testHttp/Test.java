package com.xiechy.testHttp;


import java.io.IOException;  
  
import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.HttpException;  
import org.apache.commons.httpclient.methods.GetMethod;  
  
  
public class Test {  
    private void test(){  
        HttpClient client = new HttpClient();  
        String queryString = "{\"className\":\"QueryLaw\",\"userId\":\"5\",\"search\":\"6auY5by6\",\"pageSize\":\"10\",\"pageNum\":\"1\"}";  
        String url = "http://localhost:8080/jsp/http/json_command.action?strTemp=";  
        GetMethod get=new GetMethod(url+queryString);  
        System.out.println("para="+queryString);  
        String result = "";  
        try {  
            client.executeMethod(get);  
            result = new String(get.getResponseBody(),"UTF-8");  
            System.out.println("restConn-----------------------------------"+result);  
        } catch (HttpException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) {  
        Test test = new Test();  
        test.test();  
    }  
}  