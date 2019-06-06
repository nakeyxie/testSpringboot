package com.xiechy.testEnum;

/**
 * @author xiechy
 * @create 2019-04-28
 * @Descrption
 **/

//枚举类名为A
public enum A {
    //枚举值小a,小a有2个属性
    a("属性1","属性2");

    //枚举类A的构造方法
    A(String pro1, String pro2){
        this.pro1 = pro1;
        this.pro2 = pro2;
    }

    //属性1
    private String pro1;

    //属性2
    private String pro2;

    //增加想要的方法，这里是获取枚举的属性方法
    public String getPro1(){
        return this.pro1;
    }


}




    
        