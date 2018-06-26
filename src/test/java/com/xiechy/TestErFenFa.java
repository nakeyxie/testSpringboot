package com.xiechy;

/**
 * @author xiechy
 * @create 2018-06-13
 * @Descrption 二分查找方法
 **/
public class TestErFenFa {

    public static void main(String[] args) {
        Integer[] srcArray ={1,2,3,4,5,6,7,8,9,10};
        int i = binarySearch(srcArray,3);
        System.out.println("下标:"+i);
    }

    public static int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        int times =0;
        while (low <= high) {
            times++;
            //计算出中间索引值
            int middle = (high + low)>>>1 ;//防止溢出
            if (des == srcArray[middle]) {
                System.out.println("查找次数:"+times);
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }

        }
        System.out.println("查找次数:"+times);
        //若没有，则返回-1
        return -1;
    }
}




    
        