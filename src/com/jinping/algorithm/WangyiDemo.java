package com.jinping.algorithm;

import java.util.Arrays;

/**
 * @Classname WangyiDemo
 * @Description 找出给定无序数组中未出现的最小正整数
 * @Date 2020/12/18 3:31 下午
 * @Created by tinner
 */
public class WangyiDemo {

    public static void main(String[] args) {
        System.out.println(funcFinal(new int[]{-5,-1,5,1,6,2}));
        System.out.println(funcFinal(new int[]{3,2,1,5,4}));
    }

    private static int funcFinal(int[] arr) {
        System.out.println("原数组："+ Arrays.toString(arr));
        /*
         * right是一个边界值，表示用数组中元素组成的从1开始的连续整数序列中可能的最大值（初始等于数组长度）。
         * 处理数组过程中如果遇到比right大的数，就表示该数不合法，应该被丢掉（代码中还处理了其它表示数不合法的情况）。
         * >> 随着数组元素被处理，每遇到一个不合法的元素，就应将right减1。
        */
        int right = arr.length;
        /*
         * 索引left（初始为0），left将数组分成两部分。
         * [0,left)是处理完成的部分，其中每个元素都满足a[i]=i+1;
         * [left,right]是待处理部分。
         * >> 随着数组元素被处理，left会逐渐向右移动。
         */
        int left = 0;

        while (left + 1 <= right) { // 正在处理的元素的值(left+1) <= 边界值
            // 分支1、arr[left]在理想的位置
            // 则处理完成部分长度加1，然后继续处理未完成部分的下一个待处理元素
            if (arr[left] == left + 1) {
                left++;
            } else if (arr[left] < left + 1 || arr[left] > right) {
                // 分支2、arr[left]是不合法的数据
                // 则先将right减1，然后丢掉不合法的数并将待处理部分最后一个元素填充到left位置继续处理
                right--;
                arr[left] = arr[right];
            }else {
                // 分支3、arr[left]合法，但是没有在理想的位置上
                // 则需要交换arr[left]与其理想位置上元素，然后继续处理交换后left位置处的元素
                // 求理想位置p的索引：p+1 = arr[left] >> p = arr[left]-1

                // 如果要交换的两个元素相同，也算当前处理的元素arr[left]不合法，进行与分支2一样的处理
                if(arr[left] == arr[arr[left] - 1]) {
                    right--;
                    arr[left] = arr[right];
                } else {
                    swap(arr, left, arr[left] - 1);
                }
            }
        }
        System.out.println("处理后:" + Arrays.toString(arr));
        return left + 1;
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}