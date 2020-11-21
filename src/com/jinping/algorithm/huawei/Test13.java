package com.jinping.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Classname Test13
 * @Description
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * @Date 2020/10/29 5:43 下午
 * @Created by jinping
 */
public class Test13 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = bufferedReader.readLine();
        }
        Arrays.sort(strings);
        for (String str : strings) {
            System.out.println(str);
        }

    }

}
