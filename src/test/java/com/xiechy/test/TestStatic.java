package com.xiechy.test;

public class TestStatic {
	
	public static void funA(){
		TestStatic t = new TestStatic();
		t.funB();
	}
	
	public void funB(){
		System.out.println("实例方法！");
	}

}


abstract class TestAbstruct{
	public void fun1(){}
	abstract void fun2();
}

//公共类型的接口只能定义在自己的原文件中
/*public interface InterfaceA{
	a();
}*/