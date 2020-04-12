package com.xiechy.testDigui;

public class testDigui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

       /* int k = funtion(6);
        System.out.println(k);
        */
        int j = funtion2(6,1);
        System.out.println(j);

	}
	
	/*递归函数*/
	public static int funtion(int n){
		if(n==1){
		return n;
		}else{
			return n*funtion(n-1);
		}
	}
	
	public static int funtion2(int n,int result){
		if(n==1){
			/*当次数为1时，返回结果*/
			/*返回结果不像上面那个还要回归原来的那行（return n*funtion(n-1);） 下面这个只需要回归一次（return funtion2(n-1,n*result);）*/
			return result;
		}else{
			//6*1
			//5*6
			//4*5*6
			//...
			//2*3*4*5*6
			//返回
			return funtion2(n-1,n*result);
		}
		
	}
	

}
