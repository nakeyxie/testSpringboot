package com.xiechy;

import com.xiechy.code.User;
import org.junit.Test;

/**
 * @author xiechy
 * @create 2018-02-06
 * @Descrption
 **/
public class TestElse {
    public static void main(String[] args) {
        //else if 和if是互斥的，跑了if就不会跑else if 条件判断
        String testStr="abc";
        if(testStr.equals("abc")){
            System.out.println("good");
        }else if(testStr.startsWith("a")){
            System.out.println("yes");
        }
    }


    @Test
    public void test(){
        User a = new User();
        a.setSarlay(null);
        System.out.println(1 == a.getId());
    }
}




    
        