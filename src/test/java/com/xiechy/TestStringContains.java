package com.xiechy;

import org.springframework.util.StringUtils;

/**
 * @author xiechy
 * @create 2018-03-08
 * @Descrption
 **/
public class TestStringContains {
    public static void main(String[] args) {
        String dataFrom ="testString";
        if(StringUtils.isEmpty(dataFrom)){
            System.out.println("isEmpty!");
        }else if(dataFrom.contains("test")){
            System.out.println("包含！");
        }
    }
}




    
        