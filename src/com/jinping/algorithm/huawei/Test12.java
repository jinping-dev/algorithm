package com.jinping.algorithm.huawei;

import java.util.Scanner;

/**
 * @Classname Test12
 * @Description
 *
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”34 下午
 * @Created by jinping
 */
public class Test12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        System.out.println(printNum(num));
    }

    private static String printNum(String num) {
        String result = "";
        String[] strings = num.split(" ");
        for (int i = strings.length - 1; i >= 0;i--){
            result += strings[i];
            if(i != 0){
                result += " ";
            }
        }
        return result;
    }


}
