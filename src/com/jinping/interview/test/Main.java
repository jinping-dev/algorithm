package com.jinping.interview.test;

/**
 * @Classname Test05
 * @Description
 * @Date 2020/12/19 11:55 上午
 * @Created by jinping
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,6,9};
        move(nums);
    }

    public static void move(int[] array){
        int avg = 0;
        int sum = 0;
        for(int i = 0; i< array.length;i++){
            sum += array[i];
        }
        avg = sum/array.length;
        for(int i = 0; i< array.length;i++){
            if(array[i] < avg){
                print(i,array,avg);
            }
        }
    }

    public static void print(int i, int[] temp,int avg){
        for(int j = i + 1;j < temp.length;j++){
            if(temp[j] > avg){
                while(temp[i] <= avg && temp[j] > avg){
                    temp[j] --;
                    temp[i] ++;
                    System.out.println(j +"->"+ i);
                }
            }
        }
    }

}