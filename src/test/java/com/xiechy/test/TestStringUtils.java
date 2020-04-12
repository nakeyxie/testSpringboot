package com.xiechy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class TestStringUtils {
	
	public static void main(String[] args) {
		String result=StringUtils.repeat("a        b          c ",3);
		System.out.println(result);
		
		//用空格分割成数组，null为null
	    ArrayToList(StringUtils.split("中	华 人民  共 和"));
	    
	}



//将数组转换为List
private static void ArrayToList(String[] str){
    System.out.println(Arrays.asList(str) + " 长度:" + str.length);
}

//获得集合数据
@SuppressWarnings("unchecked")
private static List getListData(){
    List list = new ArrayList();
    list.add("你好");
    list.add(null);
    list.add("他好");
    list.add("大家好");
    return list;
}
//博文来源：http://yijianfengvip.blog.163.com/blog/static/175273432201212221935832/
//获得数组数据 
@SuppressWarnings({ "unused", "unchecked" })
private static String[] getArrayData(){
    return (String[]) getListData().toArray(new String[0]);
}


}
