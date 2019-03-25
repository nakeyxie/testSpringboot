package com.xiechy.Date;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    /**
     * @param httpArg :日期参数yyyyMMdd
     * @return 返回结果
     * 返回数据：工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
     */
    public static JSONObject request(String httpArg) {
        BufferedReader reader = null;
        String result = null;
        JSONObject jsonObjectResult = null;
        StringBuffer sbf = new StringBuffer();
        //String httpUrl = "http://www.easybots.cn/api/holiday.php?d=" + httpArg;
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
            jsonObjectResult = JSONObject.parseObject(result);//转为JSONObject对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObjectResult;
    }

    public static void main(String[] args) {

        Date date1 =getYearFirst(2019);
        String date ="20190101";
       while (!"20200101".equals(date)){
           try {
                Thread.sleep(100);
           } catch (Exception e) {

           }
           JSONObject object = request(date);
           String code = object.get("data").toString();
           System.out.println(date+":"+code);
           date1 = getDayAfter(date1);
           date =transToStr(date1);
       }
    }

    /**
     * 获取日期后一天
     *
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + 1);
        return gregorianCalendar.getTime();
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }


    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }
    public static  String transToStr(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

}