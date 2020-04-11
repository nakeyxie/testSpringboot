package com.xiechy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiechy
 * @create 2018-01-25
 * @Descrption
 **/
public class Testmap {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<String, String>();
        System.out.println(testMap.toString());
        test(testMap);
        //以下2个打印等效
        System.out.println(testMap.toString());
        System.out.println("testMap:"+testMap);
    }

    private static void test(Map<String, String> testMap) {
        testMap.put("1", "1");
        testMap.put("2", "2");
    }


    /**
     * 测试指定类型的hashMap的getKey方法
     *
     */
    @Test
    public void test() {
        Map<Long, Object> testMap = new HashMap<Long, Object>();
        Long long1 =1L;
        Long long2 =2L;
        testMap.put(long1,new Object());
        testMap.put(long2,new Object());
        //空指针，原因：虽然testMap指定类型了，但是get方法是传Object进去的，如果不注意类型转换，就会返回null
        System.out.println(testMap.get("1"));

    }

    /**
     * 测试map进入方法后不返回是否改变
     * 测试结果：改变
     */
    @Test
    public void test2(){
        Map<Long, Object> testMap = new HashMap<Long, Object>();
        System.out.println(testMap);
        changMap(testMap);
        System.out.println("------------");
        System.out.println(testMap);
    }

    private void changMap(Map<Long, Object> testMap) {
        testMap.put(1L,"test");
        testMap.put(2L,"test");
        testMap.put(3L,"test");
        testMap.put(4L,"test");
        System.out.println("456"+testMap.get(null));

    }

}




    
        