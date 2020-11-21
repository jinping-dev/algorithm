package com.jinping.algorithm.huawei;

import java.util.BitSet;
import java.util.Scanner;

public class Test10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        System.out.println(printNum(num));
    }

    private static int printNum(String num) {
        BitSet bitSet = new BitSet();
        for (int i = 0 ; i < num.length() ; i++){
            if (!bitSet.get(num.charAt(i))){
                 bitSet.set(num.charAt(i));
            }
        }
        return bitSet.cardinality();
    }


}
