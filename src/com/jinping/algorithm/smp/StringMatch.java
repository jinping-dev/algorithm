package com.jinping.algorithm.smp;

/**
 * @Classname StringMatch
 * @Description
 * @Date 2020/10/25 1:25 下午
 * @Created by jinping
 */
public class StringMatch {

    public static void main(String[] args) {
        String str1 = "小花生你好，我是靳平，请问你是小花生吗？";
        String str2 = "我是靳平";
        int index = match(str1,str2);
        System.out.println(index);
    }

    //暴力匹配
    private static int match(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int str1Length = str1.length();
        int str2Length = str2.length();
        //i指向索引str1
        int i = 0;
        //j指向索引str2
        int j = 0;
        while (i < str1Length && j < str2Length){
            if (char1[i] == char2[j]){
                i++;
                j++;
            }else{
                //没有匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }

        if(j == str2Length){
            return i - j;
        }else{
            return  -1;
        }

    }
}
