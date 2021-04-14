package com.jinping.interview.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Test
 * @Description
 * 给定一个有序(非降序)数组A，可能含有重复元素，求最小的i使得A[i]等于target，不存在则返回-1。
 * @Date 2020/12/16 8:11 下午
 * @Created by jinping
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {1,3,5,5,5,5,5,9};
        int target = 9;
//        int result = proecss(nums,target);
//        int result2 = process2(nums,target);
        int asd = binSearch_1(target, nums);
        System.out.println(asd);
    }

    private static int process2(int[] nums, int target) {
        int result = -1;
        int index = 0,r = nums.length,mid = 0;
        while (index < r){
            mid = (int) Math.floor((index + r)/2);
            if (nums[mid] < target){
                while (nums[mid] == nums[mid + 1]){
                    mid ++;
                }
                index = ++mid;
            }else if(nums[mid] > target){
                while (nums[mid] == nums[mid - 1]){
                    mid --;
                }
                r = --mid;
            }else{
                int reset1 = mid,reset2 = mid;
                while (reset1 <= r && nums[reset1] == nums[reset1 + 1]){
                    reset1 ++;
                }
                while (reset2 >= index && nums[reset2] == nums[reset2 - 1]){
                    reset2 ++;
                }
                return reset1-reset2 + 1;
            }
        }
        return result;

    }

    /*
     *循环实现二分算法
     */
    public static int binSearch_1(int key, int[] array) {
        int low = 0; //第一个下标
        int high = array.length - 1;//最后一个下标
        int middle = 0;
        //防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (middle == key) {
//                while (true){
//                    middle --;
//                    if (middle != key){
//                        middle ++;
//                        break;
//
//                    }
//                }
                return array[middle];
            } else if (middle < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    private static int proecss(int[] nums, int target) {
        int result = -1;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0 ;i < nums.length;i ++){
            if (hashMap.get(nums[i]) != null){
                if (i < hashMap.get(nums[i])){
                    hashMap.put(nums[i],i);
                }
            }else{
                hashMap.put(nums[i],i);
            }
        }
        Integer index = hashMap.get(target);
        if (index != null){
            result = index;
        }
        return result;
    }


}
