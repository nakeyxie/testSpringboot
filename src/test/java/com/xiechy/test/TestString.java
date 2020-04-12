package com.xiechy.test;
public class TestString {
   public static String reverse(String s){
	   char []c=new char[s.length()];
	   for(int i=0;i<s.length();i++)
		   c[i]=s.charAt(s.length()-1-i);
	   return String.valueOf(c);
   }
	public static void main(String[] args) {
		String s="abcdefg";
		s=reverse(s);
		System.out.println(s);
	}

}