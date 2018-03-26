package com.xiechy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiechy
 * @create 2018-03-05
 * @Descrption
 **/
public class TestList {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        List subList =list.subList(0,2);
        System.out.println("subList:"+subList);
    }
}




    
        