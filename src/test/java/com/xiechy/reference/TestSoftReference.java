package com.xiechy.reference;

import java.lang.ref.SoftReference;
import java.sql.SQLOutput;

/**
 * 软引用
 */
public class TestSoftReference {

    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch ( Exception e){
            e.printStackTrace();
        }
        System.out.println(m.get());

        //再分配一下数据，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024*1024*10];//10M
        System.out.println(m.get());
    }
}
