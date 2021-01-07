package com.jinping.boss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname FindLowst
 * @Description FindLowst
 * @Date 2020/12/23 5:04 下午
 * @Created by tinner
 */
public class FindLowst {

    public static void main(String[] args) {
        int[] arr = {5,8,9,10,100,3,2,13};
        int k = 4;
        int[] leastNumbers = getLeastNumbers(arr, k);
        Arrays.sort(leastNumbers);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getLeastNumbers(int[] arr,int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return  num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }

}
