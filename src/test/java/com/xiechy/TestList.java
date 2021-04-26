package com.xiechy;

import org.apache.tools.ant.taskdefs.optional.sos.SOS;

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
        //subList包头不包尾
        List subList =list.subList(0,2);
        System.out.println("subList:"+subList);
        //java.util.ConcurrentModificationException    subList之后不能对list进行结构性的修改
        list.add(11);
        System.out.println("subList:"+subList);
    }
}




    
        