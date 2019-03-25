package com.xiechy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiechy
 * @create 2019-02-27
 * @Descrption 测试for循环
 **/
public class TestFor {

    public static void main(String[] args) {

        List<String> testStrings = new ArrayList<String>();
        //List<String> testStrings = null    报错
        for(String i : testStrings){
            System.out.println(i);
        }
        System.out.println("无报错!");

    }
}




    
        