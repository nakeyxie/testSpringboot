package com.xiechy.testString;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiechy
 * @create 2018-08-30
 * @Descrption   关于StringBuffer
 **/
public class StringBufferTest {


    /**
     * 拼接集合元素，去除最后一个逗号
     * @param list
     * @return
     */
    public static String getListStr(List<String> list){
        StringBuffer buffer  = new StringBuffer();
        for(String str : list){
          buffer.append(str).append(",");
        }
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
    }

    public static void main(String[] args) {
        List<String> testList = Arrays.asList("test1","test2","test3","testEnd");
        System.out.println(getListStr(testList));
    }

}




    
        