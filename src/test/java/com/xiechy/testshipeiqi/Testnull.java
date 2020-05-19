package com.xiechy.testshipeiqi;

public class Testnull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a =null;
		run(a);

	}

	private static void run(String a) {//参数可以传null进去
		if(a==null){
			System.out.println("可以");
		}
		
	}

}
