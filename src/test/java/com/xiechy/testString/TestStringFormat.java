package com.xiechy.testString;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author xiechy
 * @create 2018-09-06
 * @Descrption sting的format方法测试
 **/
public class TestStringFormat {

    public static void main(String[] args) {
        //占位符，暂定2位的数字字符串，如果数字位数不足，用零补充
        System.out.println(String.format("%02d", 12));//12
        System.out.println(String.format("%02d", 123));//123
        //1前补零
        System.out.println(String.format("%02d", 1));//01
        //2前补两个零(3位数)
        System.out.println(String.format("%03d", 2));//002
        //%s为占位符
        System.out.println(String.format("样本编号%s错误", "test1"));//样本编号test1错误
        //用法
        System.out.println(String.format("样本编号有误：%s", StringUtils.join(Arrays.asList("t1","t2","t3","t4"),";")));
        //样本编号有误：t1;t2;t3;t4
        System.out.println(String.format("test1","test2","tes3","test4"));
    }
}




    
        