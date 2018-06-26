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
        System.out.println("Q" + DateToStr(new Date(), "yy") + String.format("%06d", 1));
    }

    public static String DateToStr(Date date, String form) {
        SimpleDateFormat format = new SimpleDateFormat(form);
        String str = format.format(date);
        return str;
    }
}




    
        