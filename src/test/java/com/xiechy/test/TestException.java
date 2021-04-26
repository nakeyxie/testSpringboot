package com.xiechy.test;

public class TestException {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception  {
		String testStr=null;
		try {
			fun(testStr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("打印异常");
			throw new Exception();
		}

	}
	public static void fun(String s)throws Exception{
		try {
			if(s.equals("string")){
				System.out.println('A');
			}
		} catch (Exception e) {
		//e.printStackTrace(); 注释了就不会打印堆栈异常了
		  throw new NullPointerException();
		}
	}

}
