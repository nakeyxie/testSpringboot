package com.xiechy.testReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

import org.junit.Test;

import com.xiechy.test.TestTime;

public class testMain {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException {
		/*
		 * //第一步， 先把HelloWorld的类装载进来 Class cls =
		 * Class.forName("com.example.HelloWorld"); //第二步， 创建一个HelloWorld的实例，
		 * 注意， 这里并没有用强制转型把obj转成HelloWorld Object obj = cls.newInstance(); //第三步，
		 * 得到这个类的方法， 注意， 一个类的方法也是对象啊 Method m =
		 * cls.getDeclaredMethod("sayHello"); //第四部， 方法调用， 输出"hello world"
		 * m.invoke(obj);
		 */
		Class c = Class.forName("com.xiechy.testReflect.HelloWord");
		Object o = c.newInstance();
		Method m = c.getDeclaredMethod("sayHello");
		m.setAccessible(true);
		m.invoke(o, new Class[] {});
		Class c1 = TestTime.class;
		Field[] f = c1.getFields();
		try {
			Field f1 = c1.getDeclaredField("");// 获取具体属性
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test(){
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}

}
