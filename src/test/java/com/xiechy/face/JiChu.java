package com.xiechy.face;

public class JiChu {

	public static void main(String[] args) {
		Test j = new Test();
		j.trans(j.i, j.str, j.ints);
		System.out.println(j.i);
		System.out.println(j.str);
		System.out.println(j.ints);

	}

}

class Test {

	public int i = 1;
	public String str = "1";
	public Integer ints = 2;

	public void trans(int i, String str, Integer ints) {
		this.i = 2;
		str = "2";
		ints = 3;
	}
}
