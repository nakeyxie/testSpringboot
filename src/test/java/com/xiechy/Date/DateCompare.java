package com.xiechy.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiechy
 * @create 2018-07-23
 * @Descrption
 **/
public class DateCompare {

    public static void main(String[] args) throws Exception{

       /* 之前有面试到两个日期的大小比较方式，现在整理一下几种方法。

        例子：*/

        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-05-08 11:22:22");

     /*   1  直接用Date自带方法before()和after()比较*/

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date sd1=df.parse(beginTime);
        Date sd2=df.parse(endTime);

        System.out.println(sd1.before(sd2));
        System.out.println(sd1.after(sd2));



       /* 2  用String的compareTo()方法：*/

        Integer i=beginTime.compareTo(endTime);

        System.out.println(i);

       /* 返回正值是代表左侧日期大于参数日期，反之亦然，日期格式必须一致



        3  转成date格式换成秒数比较秒数大小，getTime()方法*/

        Date sd3=df.parse(beginTime);
        Date sd4=df.parse(endTime);

        long long1 =sd1.getTime();

        long long2= sd2.getTime();



        /*另附日期和string的互转方法：*/

      /*  1  Date转String*/

        Date d=new Date();

        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String ds=df2.format(d);



       /* 2 String转Date*/

        String ds1=new String("2017-06-09 10:22:22");

        Date sd=df.parse(ds);
    }
}




    
        