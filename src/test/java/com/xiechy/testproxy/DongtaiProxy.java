package com.xiechy.testproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DongtaiProxy implements InvocationHandler {
	private  Object target=null;
	
	
	/*
	 * 
	 * JDK动态代理中包含一个类和一个接口： 
InvocationHandler接口： 
public interface InvocationHandler { 
public Object invoke(Object proxy,Method method,Object[] args) throws Throwable; 
} 
参数说明： 
Object proxy：指被代理的对象。 
Method method：要调用的方法 
Object[] args：方法调用时所需要的参数 

可以将InvocationHandler接口的子类想象成一个代理的最终操作类，替换掉ProxySubject。 

Proxy类： 
Proxy类是专门完成代理的操作类，可以通过此类为一个或多个接口动态地生成实现类，此类提供了如下的操作方法： 
public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, 
InvocationHandler h) 
                               throws IllegalArgumentException 
	 * 
	 * 
	 * 参数说明： 
	ClassLoader loader：类加载器 
	Class<?>[] interfaces：得到全部的接口 
	InvocationHandler h：得到InvocationHandler接口的子类实例 

	Ps:类加载器 
	在Proxy类中的newProxyInstance（）方法中需要一个ClassLoader类的实例，ClassLoader实际上对应的是类加载器，在Java中主要有一下三种类加载器; 
	Booststrap ClassLoader：此加载器采用C++编写，一般开发中是看不到的； 
	Extendsion ClassLoader：用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类; 
	AppClassLoader：(默认)加载classpath指定的类，是最常使用的是一种加载器。 */
	
	/*绑定委托对象，并返回一个代理类*/
    public Object bind(Object targe){
    	this.target=targe;
    	
    	 //取得代理对象  （返回的对象肯定是已经实现了那个接口的）
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
    	
    }
	
	
	
    /**
     * args:方法所需参数
     * 
     * ｛此方法在main方法代理类执行方法的时候会调用到！｝
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		Object result=null;  
        System.out.println("事物开始");  
        //执行方法  
        result=method.invoke(target, args);  
        System.out.println("事物结束");  
        return result;  
	}
	
	
}
