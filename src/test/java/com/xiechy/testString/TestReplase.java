package com.xiechy.testString;

import org.junit.Test;

/**
 * @author xiechy
 * @create 2018-07-23
 * @Descrption
 **/
public class TestReplase {

    @Test
    public void test(){
        String testStr ="A-2";
        if(testStr.contains("-")){
            testStr =testStr.replace("-","");
        }
        System.out.println(testStr);
    }
}




    
        