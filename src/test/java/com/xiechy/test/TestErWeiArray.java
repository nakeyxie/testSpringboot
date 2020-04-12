package com.xiechy.test;

public class TestErWeiArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int[][] arr = new int [3][3];//定义一个二维数组  
		    int sum =0;//记录长度  
		    for(int a = 0 ;a<arr.length;a++){//获取行的长度  
		        for(int b = 0 ;b<arr[a].length;b++){//获取列的长度  
		        	System.out.println("a:"+a+",b:"+b);
		            sum++;//长度+1  
		        }  
		    }  
		    System.out.println(sum);//输出长度  
		    
		
       System.out.println("---------------------------");		    
       int[][] arr2={{1},{1,2},{1,2,3},{1,2,3,4},{1,2,3,4,5},{1,2,3,4,5,6}};
       for(int i=0;i<arr2.length;i++){
    	   for(int j=0;j<arr2[i].length;j++){
    		   System.out.print("a"+i+j+":"+arr2[i][j]+" ");
    	   }
    	   System.out.println();
       }

	}

}
