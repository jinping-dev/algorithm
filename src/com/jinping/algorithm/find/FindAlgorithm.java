package com.jinping.algorithm.find;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FindAlgorithm
 * @Description 查找算法
 * @Date 2020/10/24 10:48 下午
 * @Created by jinping
 */
public class FindAlgorithm {

    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1000,1234};
        int index = binarySearch(arr,0,arr.length - 1,8);
        System.out.println(index);
        List index2 = binarySearch2(arr,0,arr.length - 1,1000);
        System.out.println(index2);
    }

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param number 要查找的值
     * @return
     */
    private static int binarySearch(int[] arr, int left, int right, int number) {
        if (left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midValue = arr[mid];
        if (midValue > number){
            return binarySearch(arr,left,mid - 1 , number);
        }else if(midValue < number){
            return binarySearch(arr,mid + 1,right, number);
        }else{
            return mid;
        }
    }

    //优化：比如：[1,2,3,5,5,5,5,5,8,9]返回5对应的下标，返回数组[3,4,5,6,7]
    private static List<Integer> binarySearch2(int[] arr, int left, int right, int number) {
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right)/2;
        int midValue = arr[mid];
        if (midValue > number){
            return binarySearch2(arr,left,mid - 1 , number);
        }else if(midValue < number){
            return binarySearch2(arr,mid + 1,right, number);
        }else{
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0||arr[temp] != number){
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);
            int temp2 = mid + 1;
            while (true){
                if (temp2 > arr.length - 1||arr[temp2] != number){
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}
