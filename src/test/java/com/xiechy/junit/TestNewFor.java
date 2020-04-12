package com.xiechy.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TestNewFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap hashmap = new HashMap();
		hashmap.put(1, "one");
		hashmap.put(2, "two");
		hashmap.put(3, "three");
		hashmap.put(4, "four");
		hashmap.put(5, "fine");
		Iterator i = hashmap.entrySet().iterator();//获取迭代器
		ArrayList arr = new ArrayList();
		for(hashmap.entrySet().iterator();i.hasNext();System.out.println(i.next().toString()));//for循环里做事
		Object[] o = arr.toArray();
		System.out.println(o[2].toString());

	}

}
