package com.xiechy.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName PriorityQueueSort
 * @Description 优先队列不再遵循先入先出的原则，而是分为两种情况：
 *
 * 最大优先队列，无论入队顺序，当前最大的元素优先出队；
 * 最小优先队列，无论入队顺序，当前最小的元素优先出队；
 *
 * Java内部sort排序使用的排序算法
 *
 * 元素个数 < 47 : 插入排序
 *
 * 47 <= 元素个数 < 286 : 快速排序
 *
 * 元素个数 > 286 ：归并排序
 * @Author xcy
 * @Date 2021/5/7 17:20
 */
public class PriorityQueueSort {

    /**
     * 利用优先队列排序
     * @param arr
     * @return
     */
    public int[] PriorityQueueSort(int[] arr){

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] newarr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newarr[i] = queue.poll();
        }
        return newarr;
    }
}
