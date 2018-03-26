package com.xiechy;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author xiechy
 * @create 2018-03-01
 * @Descrption
 **/
public class TestBigdecimal {
    public static void main(String[] args) {
        String test = null;
        BigDecimal conc = new BigDecimal(Optional.ofNullable(test).orElse("0"));
        System.out.println(conc);
    }
}




    
        