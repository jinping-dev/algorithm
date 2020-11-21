package com.jinping.algorithm.huawei;

import java.util.BitSet;
import java.util.Scanner;

public class Test11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        System.out.println(printNum(num));
    }

    private static StringBuilder printNum(String num) {
        StringBuilder result = new StringBuilder();
        for (int i = num.length() - 1 ; i >= 0 ; i--){
            result.append(num.charAt(i));
        }
        return result;
    }


}

