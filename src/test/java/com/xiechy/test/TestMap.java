package com.xiechy.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

	/**
	 * @param args
	 */
	static Object  lockThis = new Object();
	public static void main(String[] args) {
		ConcurrentHashMap  concurrentHashMap = new ConcurrentHashMap();
		concurrentHashMap.put("1", "1");
//		ConcurrentBag<T> concurrentbag= new ConcurrentBag();

		//会抛空指针异常
		concurrentHashMap.containsKey(null);
		//线程安全的list
		List<Object> list =Collections.synchronizedList(new ArrayList<Object>());
		//线程安全的map
		Map  map = Collections.synchronizedMap(new HashMap());
		map.put("1", "0");
		map.put("2", "1");
		map.put("3", "2");
		map.put("4", "3");
		map.put("5", "4");
		map.put("6", "5");
		for(Object pk: map.keySet()){//打印是不安顺序的
			
			System.out.println(map.get(pk));
		}
	}
	
	public void Function()
	{
	Object lockThis = new Object();
	
	// Access thread-sensitive resources.

	}

	@Test
	public void testNull(){
		Map testMap1 = new HashMap();
		boolean hasNull = testMap1.containsKey(null);
		System.out.println(hasNull);
		testMap1.put(null,"123");
		boolean result = testMap1.containsKey(null);
		String value = (String)testMap1.get(null);
		System.out.println("result:"+result+","+"value"+value);
		System.out.println("不会空指针");
	}

}
