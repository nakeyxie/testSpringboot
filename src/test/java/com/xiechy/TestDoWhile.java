package com.xiechy;

import java.util.Random;

/**
 * @author xiechy
 * @create 2019-07-29
 * @Descrption
 * do-while循环与while循环的不同在于：
 * 它先执行循环体中的语句，
 * 然后再判断条件是否为真。
 * 如果为真则继续循环，
 * 如果为假，则终止循环。
 * 因此，do-while循环至少要执行一次循环语句。
 * 同样当有许多语句参加循环时，要用“{”和“}”把它们括起来。
 *
 **/
public class TestDoWhile {

    public static void main(String[] args) {
         int i = 0;
         int count =10;
        Random random = new Random();
        do{
            i = random.nextInt(15);
            System.out.println(i);
        }while(i < count);

    }
}




    
        