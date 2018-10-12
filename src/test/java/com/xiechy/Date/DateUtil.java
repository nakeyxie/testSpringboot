package com.xiechy.Date;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DateUtil {
    /**
     * @param httpArg :日期参数yyyyMMdd
     * @return 返回结果
     * 返回数据：工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
     */
    public JSONObject request(String httpArg) {
        BufferedReader reader = null;
        String result = null;
        JSONObject jsonObjectResult = null;
        StringBuffer sbf = new StringBuffer();
       // String httpUrl = "http://www.easybots.cn/api/holiday.php?d=" + httpArg;
        String httpUrl = "http://api.goseek.cn/Tools/holiday?date=" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            System.out.println("reuslt:"+result);
            jsonObjectResult = JSONObject.parseObject(result);//转为JSONObject对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObjectResult;
    }

    public static void main(String[] args) {
        JSONObject a = new DateUtil().request("20180222");
        System.out.println(a);
    }
}