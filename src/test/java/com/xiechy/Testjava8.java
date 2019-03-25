package com.xiechy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
}




    
        