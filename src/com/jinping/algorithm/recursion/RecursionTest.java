package com.jinping.algorithm.recursion;

/**
 * @Classname RecursionTest
 * @Description n的阶乘
 * @Date 2020/10/24 9:10 下午
 * @Created by jinping
 */
public class RecursionTest {

    public static void main(String[] args) {
        int jiecheng = jiecheng(5);
        System.out.println(jiecheng);
    }

    public static int jiecheng(int n){
        if (n == 1){
            return 1;
        }else{
            return jiecheng(n -1) * n;
        }
    }
}
