package com.xiechy.testproxy;

public class Dongtaibookimpl implements Dongtaibook {

	
	public Dongtaibookimpl(){
		
	}


	public void addBook() {
		testExtractMethod();
		
	}


	private void testExtractMethod() {
		System.out.println("实现类在添加书籍");
	}
	int  i;
    public static void test(){
    	//i=1;  静态方法不能直接访问实例变量，只能访问静态变量！
    }




}
