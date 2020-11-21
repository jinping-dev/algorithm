package com.jinping.algorithm.huawei;

import java.util.Scanner;

/**
 * @Classname Test02
 * @Description
 * @Date 2020/10/29 10:47 上午
 * @Created by jinping
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String charNum = sc.nextLine();
        int num = patchNum(str,charNum);
        System.out.println(num);
    }

    private static int patchNum(String str, String charNum) {
        int result = 0;
        if (str != null && charNum != null){
            if (charNum.length() > 1 || str.length() == 0){
                return 0;
            }
            int index = 0;
            while (index < str.length()){
                if (charNum.equalsIgnoreCase(String.valueOf(str.charAt(index)))){
                    result ++;
                }
                index ++;
            }
        }else{
            return 0;
        }


        return result;
    }
}
