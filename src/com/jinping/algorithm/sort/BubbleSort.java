package com.jinping.algorithm.sort;

import java.util.Arrays;

/**
 * @Classname bubbleSort
 * @Description 冒泡排序
 * @Date 2020/10/24 9:27 下午
 * @Created by jinping
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,90,45,66,12};
        bubbleSort(nums);
        System.out.println("asd");
    }

    //冒泡排序
    public static void bubbleSort(int[] nums){
        int temp = 0;
        for (int i = 0;i < nums.length; i++){
            for (int j = i;j<nums.length;j++){
                if (nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int[] nums){
        int temp = 0;
        for (int i = 0;i < nums.length - 1 ; i++){
            //拿到当前索引的元素的值和当前的索引下标
            int minIndex = i;
            int min = nums[i];
            //与后面的元素进行比较
            for (int j = i + 1;j<nums.length;j++){
                //找出后面的最小值和最小值对应的index
                if (min > nums[j]){
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }

    public static void quickSort(int[] nums,int left,int right){
        int l = left;
        int r = right;
        int prov = nums[(left + right)/2];
        //临时变量，作为交换使用
        int temp = 0;
        //while循环的目的是让比prov值小的放到左边,比prov值大的放到右边
        while (l<r){
            //在prov的左边一直找，找到大于等于prov的值才退出
            while (nums[l] < prov){
                l +=1;
            }
            while (nums[r] < prov){
                r -=1;
            }

            //如果l>=r。说明已经满足
            if (l >= r){
                break;
            }

            //交换
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            if (nums[l] == prov){
                r -= 1;
            }
            if (nums[r] == prov){
                l += 1;
            }
        }

        if (l ==r){
            l +=1;
            r -=1;
        }
        if (left < r){
            quickSort(nums,left,r);
        }
        if (right > l){
            quickSort(nums,l,right);
        }
    }

}
