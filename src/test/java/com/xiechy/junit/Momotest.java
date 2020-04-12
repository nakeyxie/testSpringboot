package com.xiechy.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xiechy.testproxy.Weituoclass;

/**
 * 练习 junit 测试类
 * @author Administrator
 *
 */
public class Momotest {
	//步骤1：导包，junit4
	//步骤2：创建测试类（规范：待测试类名称+Test后缀）
	//步骤3:创建测试方法，必须是public的void的，名称建议test开头+测试方法
	//步骤4：测试方法加注解，加@Test
	//在类点运行junit就是运行所有test
	
	@Before
	public void beforeTest(){
		System.out.println("准备");
	}
	
	
	@Test
	public void testMothod(){
		Weituoclass  weituo = new Weituoclass();
		weituo.Query1();
		
	}
	@After
	public void afterTest(){
		System.out.println("测试结束");
	}
	
	@Test
	public void testNewfor(){
		int[] arr = new int[]{};
		//编译器做了手脚，遍历数组时：普通for循环  遍历集合时，都是遍历了实现了Iterable接口的类，使用迭代器来循环
		//长度为0时不会报错
		for(int i:arr){
			System.out.println(i);
		}
	}
	

}
