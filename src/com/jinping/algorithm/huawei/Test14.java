package com.jinping.algorithm.huawei;

import java.util.Scanner;

/**
 * @Classname Test14
 * @Description
 * @Date 2020/10/29 5:53 下午
 * @Created by jinping
 */
public class Test14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String toBinaryString = Integer.toBinaryString(num);
        int result = 0 ;
        for (char c:toBinaryString.toCharArray()){
            if (c == '1'){
                result ++;
            }
        }
        System.out.println(result);
    }
}
