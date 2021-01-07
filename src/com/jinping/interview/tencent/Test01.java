package com.jinping.interview.tencent;

/**
 * @Classname Test01
 * @Description
 * 1. 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @Date 2020/12/23 8:08 下午
 * @Created by jinping
 */
public class Test01 {
    public static void main(String[] args) {
        int[] array = {1,3,3,3,3,3,5,4,2};
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(process(arr));
    }

    public static int process(int[] array){
        int temp = array[0];
        int count = 1;
        for (int i = 1; i < array.length ;i++){
            count = temp == array[i] ? count +1 :count -1;
            if (count == 0){
                temp = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i ++){
            if (temp == array[i]){
                count ++;
            }
        }
        if (count > array.length / 2){
            return temp;
        }else{
            return 0;
        }
    }
}
