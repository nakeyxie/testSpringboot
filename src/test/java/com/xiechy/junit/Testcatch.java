package com.xiechy.junit;

import org.junit.Test;

public class Testcatch {
	
	@Test
	public void tesCatch(){
		try {
			int[] a = new int[4];
			System.out.println(a[4]);
			
		} catch (Exception e) {
			System.out.println("before");
			e.printStackTrace();
			System.out.println("after");
		}
	}

}
