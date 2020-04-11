package com.xiechy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiechy
 * @create 2019-07-29
 * @Descrption
 **/
public class TestSet {
    public static void main(String[] args) {
        Set<String> bigSet = new HashSet<>();
        bigSet.add("1");
        bigSet.add("2");
        bigSet.add("3");
        bigSet.add("4");
        Set<String> set = new HashSet<>();
        bigSet.add("1");
        bigSet.add("2");
        //contains 不能放集合
        System.out.println(bigSet.contains(set));//false
    }
}




    
        