package com.xiechy.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 思路：快速排序，具体如下：两个移动的指针和一个基准值，
 * 一次排序后应达到基准值是一个分水岭，按从小到大排序，左边应该比基准值小，
 * 右边应该比基准值大。基本思路是：开始left不动，
 * 如果right指向的值大于等于基准值（基准值的大小可以等于一开始left指向的值），
 * 就right--；如果不满足上述条件，就right指向的值赋给left，同时left++；
 * 如果left指向的值小于等于基准值，就left++；如果不满足，就left指向的值赋给right
 * ，同时right--；循环结束条件：left<rigth。
 * @Author xcy
 * @Date 2021/5/7 16:21
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr ={5,4,3,1,2};
        int start=0;
        int end=arr.length-1;

        quickSort(arr,start,end);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right) {
        if ( left < right) {
            //只有当left < right的时候，排序才有意义
            int i = left;//辅助左指针
            int j = right;//辅助右
            int pivot = arr[i]; // 枢轴，将所有小于pivot的数放在它左边，所有大于pivot的数放在它右边
            while (i < j) {
                //当 i == j 时，循环才结束
                while (i < j && arr[j] >= pivot) {
                    //从后往前找，找到比pivot小的数，或者 i == j
                    j--;
                }
                if (i < j) {//如果退出上个循环后，i仍小于j，说明，找到了符合条件的数
                    arr[i] = arr[j];
                    //令i位置上的数等于j位置上的数
                    //由于交换数据太耗费时间，所以用这种方法代替
                    //最开始的i位置上的数已经通过pivot保存起来，此时为无效数据，可以用来保存j上的数据
                    //而赋值完成后，j上的数据为无效数据，在下一个循环中会被修改
                }
                while(i < j && arr[i] <= pivot) {
                    //此时再从前往后找，找到比pivot大的数，或者 i == j
                    i++;
                }
                if (i < j) {
                    //此时代表找到了这么个数，可以进行赋值
                    arr[j] = arr[i];
                }
            }
            //当循环退出后，i == j,此时i,j在同一位置，且为无效数据
            //修改该位置的数据为pivot，并利用递归完成其余两部分数据的排序
            arr[i] = pivot;
            quickSort(arr,left, i - 1);//从中间位置往左
            quickSort(arr,i + 1,right);//从中间位置往右
        }
    }

   /* 快速排序(Quick Sort)：快速排序用到了分治思想，同样的还有归并排序。乍看起来快速排序和归并排序非常相似，都是将问题变小，先排序子串，最后合并。快速排序又是对冒泡排序的一种改进方法，在冒泡排序中，进行元素的比较和交换是在相邻元素之间进行的，元素每次交换只能移动一个位置，所以比较次数和移动次数较多，效率相对较低。而在快速排序中，元素的比较和交换是从两端向中间进行的，较大的元素一轮就能够交换到后面的位置，而较小的元素一轮就能交换到前面的位置，元素每次移动的距离较远，所以比较次数和移动次数较少，速度较快，故称为“快速排序”。
    快速排序的基本思想是：

    在待排序的元素任取一个元素作为基准(通常选第一个元素，但最优的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；
    将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；
    对左右两个分区重复以上步骤直到所有元素都是有序的*/
}



