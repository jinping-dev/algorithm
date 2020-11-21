package com.jinping.algorithm.huawei;

import java.util.Scanner;

/**
 * @Classname Test09
 * @Description
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * @Date 2020/10/29 5:08 下午
 * @Created by jinping
 */
public class Test09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        System.out.println(printNewNum(num));
    }

    private static int printNewNum(String str) {
        StringBuilder numStr = new StringBuilder();
        boolean isExit = false;
        for (int i = str.length() - 1; i >= 0 ; i --){
            for(int j = 0 ; j < numStr.length(); j ++){
                isExit = false;
                if (str.charAt(i) == numStr.charAt(j)){
                    isExit =true;
                    break;
                }
            }
            if (!isExit){
                numStr.append(str.charAt(i));
            }
        }
        return Integer.parseInt(numStr.toString());
    }
}


