package com.xiechy.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiechy
 * @create 2018-03-07
 * @Descrption
 **/
public class TestListSort {

    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<Integer>();
        testList.add(4);
        testList.add(3);
        testList.add(1);
        testList.add(5);
        testList.add(2);

        testList.sort((h1,h2)->h1.compareTo(h2));
        System.out.println(testList);
        System.out.println(testList.get(testList.size()-1));
    }


}




    
        