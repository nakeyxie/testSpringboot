package com.xiechy.test;

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

}
