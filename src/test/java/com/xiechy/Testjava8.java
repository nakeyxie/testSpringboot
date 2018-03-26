package com.xiechy;

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
    }
}




    
        