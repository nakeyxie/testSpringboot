package com.xiechy.http;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiechy
 * @create 2018-08-22
 * @Descrption
 **/
public class TestQcExceptionController {

    @Test
    public void testReTest(){
        try {
            String url ="http://localhost:8888/bossqc/qcException/reTest";
            Map<String,String> paramMap = new HashMap<String,String>();
            //List<Long> ids = Arrays.asList(1L,2L,3L);
            paramMap.put("ids","[1,2,3]");
            paramMap.put("handDesc","testHandDesc");
            String response = HttpUtils.URLPost(url,paramMap,"UTF-8");
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testReTestJSON(){
        try {
            String url ="http://localhost:8888/bossqc/qcException/reTest";
            JSONObject json = new JSONObject();
            //后台参数是什么类型的就设置成什么类型,然后json转换
            //后台对应字段为  ：private List<Long> ids;
            json.put("ids", Arrays.asList(1,2,3));
            json.put("handDesc","testHandDesc");
            String jsonStr = json.toJSONString();
            //如果请求是以JSON串的形式发送到后台，后端参数接收需要加requestBody
            String response = HttpUtils.URLPostJSON(url, jsonStr,"UTF-8");
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testFinishTest(){
        String url ="http://localhost:8888/bossqc/qcException/finishTest/3,4";
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("ids","1,2");
        String response = HttpUtils.URLPost(url,paramMap,"UTF-8");
        System.out.println(response);
    }

}




    
        