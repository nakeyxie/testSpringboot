package com.xiechy;

/**
 * @author xiechy
 * @create 2018-05-24
 * @Descrption  测试二维数组
 **/
public class TestErWeiArray {
    public static void main(String[] args) {
        int[][] colors ={{255,59,59}, {24,2,190}, {235,33,192}, {39,115,63}, {165,57,23},{24,176,180}};
        for(int i =0;i<8;i++){
            int[] rbg = colors[i%colors.length];
             System.out.println(i+":"+rbg[2]);

        }
    }
}




    
        