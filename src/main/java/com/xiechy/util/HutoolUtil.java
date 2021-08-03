package com.xiechy.util;

import java.util.Date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HutoolUtil {

    public static void main(String[] args) {
        HutoolUtil.testHutoolGet();
    }

    public static void testHutoolGet() {
        String getResult = HttpUtil
                .createGet("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15677386236")
                .execute()
                .charset("gbk")
                .body();
        log.info("getResult:"+getResult);
    }
    public static void testHutoolPost(String cameraId) {
        JSONObject jsonObject = JSONUtil.createObj();
        jsonObject.put("cameraId", cameraId);
        jsonObject.put("startTime", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        jsonObject.put("callback", "http://www.baidu.com");
        String postResult = HttpRequest
                .post("http://localhost:8080/v1/platedetect/tasks")
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .execute()
                .body();
        log.info("postResult:"+postResult);
    }

}