package com.xiechy.test;

public class TestJiCheng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 A a;
		    B b = new B();
		    b.fun1();//456
		    a = b;
		    a.fun1();//456
 
		    
		   /* B类的fun2方法
		    B类的fun2方法*/
		
		    Granfather sun = new Sun();
		    sun.fun();
		    

	}

}

 class A {
	 
	 void fun1(){
		 System.out.println(this.fun2());
	 }

	String fun2() {
		return "A类的fun2方法";
	}
 }
 
 class B extends A {
	 String fun2 (){
		 return "B类的fun2方法";
	 }
 }
 
 class Granfather{
	void fun(){
		System.out.println("爷爷");
	}
 }
 
 class Father extends Granfather{
	 void fun(){
		 System.out.println("爸爸");
	 }
	 
	 void funFather(){
		 super.fun();
	 }
 }
 
 class Sun extends Father{
	 void fun(){
		 /*孙类调用爷爷类的方法*/
		 //方式1
		 Granfather granfathernew = new Granfather();
		 granfathernew.fun();
		 //方式2
		 funFather();
	 }
 }

 
 
