package com.jinping.algorithm.huawei;

import java.util.Scanner;

/**
 * @Classname Test01
 * @Description
 * @Date 2020/10/28 7:13 下午
 * @Created by jinping
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = calculate(str);
        System.out.println(num);
    }

    private static int calculate(String str) {
        if (str.equals("")||str.length()>5000){
            return 0;
        }
        int index = 0;
        int result = 0;
        while(index < str.length()){
            result ++ ;
            if (str.charAt(index) == ' '){
                result = 0;
            }
            index ++;
        }
        return result;
    }
}
