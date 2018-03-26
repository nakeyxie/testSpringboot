package com.xiechy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiechy
 * @create 2018-01-25
 * @Descrption
 **/
public class Testmap {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<String, String>();
        System.out.println(testMap.toString());
        test(testMap);
        System.out.println(testMap.toString());
    }

    private static void test(Map<String, String> testMap) {
        testMap.put("1", "1");
        testMap.put("2", "2");
    }

}




    
        