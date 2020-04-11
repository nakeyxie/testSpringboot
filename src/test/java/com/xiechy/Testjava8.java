package com.xiechy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiechy
 * @create 2018-01-30
 * @Descrption
 **/
public class Testjava8 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        System.out.println(optional.isPresent());         // true
        System.out.println( optional.get() );  // "bam"
        System.out.println( optional.orElse("fallback"));  // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
        System.out.println(optional.ofNullable(null).orElse("test"));

        System.out.println("---------------");
        System.out.println(optional.ofNullable(null).orElse(0L).toString());
        System.out.println("nice");
    }



    /**
     * 测试reduce函数
     * 结果：1+2+3+4
     * 相当于累加
     */
    @Test
    public void testReduce(){
        List<Integer> params = Arrays.asList(new Integer[]{1,2,3,4});
        int result = params.stream().map(i->{
            return i;
        }).reduce(0,(h1,h2)->h1+h2);
        System.out.println(result);
    }


    /**
     * Stream的map和flatMap的区别:
     * map会将一个元素变成一个新的Stream
     * 但是flatMap会将结果打平，得到一个单个元素
     */
    @Test
    public void testFlatmap() {
        /**获取单词，并且去重**/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");
        //map和flatmap的区别
        System.out.println("map:");
        //Arrays.stream接收一个数组返回一个流
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        System.out.println("flatMap:");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());

        System.out.println("---------- ");
        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================================================");

        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        //实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

    }
}




    
        