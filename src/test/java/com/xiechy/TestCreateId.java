package com.xiechy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiechy
 * @create 2018-05-31
 * @Descrption
 **/
public class TestCreateId {
    public static void main(String[] args) {
        //string.format后面六位数，除去1，其他用0补齐
        System.out.println("Q" + DateToStr(new Date(), "yy") + String.format("%06d", 1));
        System.out.println("Q" + DateToStr(new Date(), "yy") + String.format("%06d", 201));
    }

    public static String DateToStr(Date date, String form) {
        SimpleDateFormat format = new SimpleDateFormat(form);
        String str = format.format(date);
        return str;
    }
}




    
        