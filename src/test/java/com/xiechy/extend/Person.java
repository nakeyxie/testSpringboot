package com.xiechy.extend;

/**
 * @author xiechy
 * @create 2019-06-04
 * @Descrption
 **/
public class Person {
    private String name ="Person";
    int age= 0;
}
  class Child extends  Person{
      public String grade;

      public static void main (String [] args){
         Person p = new Child();
          //编译出错
          //System.out.println(p.name);
      }
  }






    
        