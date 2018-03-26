package com.xiechy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lenovo on 2017/12/25.
 */
public class TEST1 {
    public static void main(String[] agrs){
        List list =Arrays.asList(1,2,3,4);
        List list2 = (List) list.stream().map(i->{
            int t = (Integer)i;
            t++;
            System.out.println(t);
            return t;
        }).collect(Collectors.toList());
        System.out.println(list2.toString());
    }
}
