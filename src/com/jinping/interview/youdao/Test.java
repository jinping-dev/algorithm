package com.jinping.interview.youdao;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname Test
 * @Description
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * @Date 2020/12/24 10:19 上午
 * @Created by jinping
 */
public class Test {
    public static void main(String[] args) {
        int[] arrA = {};
        int[] arrB = {1};
        System.out.println(findMidian(arrA,arrB));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        Integer remove = list.remove(0);
        System.out.println("remove:" + remove);
        list.add(2);
        Integer integer = list.get(0);
        System.out.println("list:" + integer);
    }
    public static double findMidian(int[] arrA,int[] arrB){
        int m = arrA.length;
        int n = arrB.length;
        int left = (m + n + 1)/2;
        int right = (m + n + 2)/2;
        return (find(arrA,arrB,0,0,left)+ find(arrA,arrB,0,0,right)) / 2.0;
    }

    public static int find(int[] arrA,int[] arrB,int i ,int j,int k){
        if (i >= arrA.length)
            return arrB[j + k - 1];
        if (j >= arrB.length)
            return arrA[i + k - 1];
        if (k == 1){
            return Math.min(arrA[i],arrB[j]);
        }
        int midianA = ((i + k /2 -1) < arrA.length)?arrA[(i + k/2) - 1]:0;
        int midianB = ((j + k /2 -1) < arrB.length)?arrB[(j + k/2) - 1]:0;
        if (midianA < midianB){
            return find(arrA,arrB,i+k/2,j,k-k/2);
        }else{
            return find(arrA,arrB,i,j+k/2,k-k/2);
        }
    }

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] vec = new int[k];
            if (k == 0) { // 排除 0 的情况
                return vec;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((num1, num2) -> num2 - num1);
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


}


