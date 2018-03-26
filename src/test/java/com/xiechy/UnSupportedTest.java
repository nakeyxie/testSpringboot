package com.xiechy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiechy
 * @create 2018-01-31
 * @Descrption
 **/
public class UnSupportedTest {

    public static void main(String[] args) {
        Integer [] arr = new Integer[]{23,4,56,67,89,45};
        //List<Integer> list = Arrays.asList(arr);      asList之后，这个list集合不是ArrayList 而是Arrys内部的一个一个list，所有后面会报错
        List<Integer>  testList = new ArrayList<>();
        List<Integer> list =new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println("list"+list);
        list.remove(1);//unsupported
        list.add(4);//unsupported
        System.out.println("list"+list);
        testList.addAll(list);
        System.out.println("可以");
    }
}




    
        