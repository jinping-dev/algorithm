package com.jinping.algorithm.find;

/**
 * @Classname TheLongestSubString
 * @Description TheLongestSubString
 * @Date 2020/12/10 3:33 下午
 * @Created by tinner
 */
public class TheLongestSubString {

    public static void main(String[] args) {
        String s1 = "asdfgh";
        String s2 = "1asd4";
        int s3 = longestSubString(s1,s2);
        System.out.println(s3);
    }

    private static int longestSubString(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int ret = 0 ;
        for (int i = 0; i < s1Length; i ++){
            int len = Math.min(s1Length,s2Length - i);
            int maxLen = maxLength(s1,s2,i,0,len);
            ret = Math.max(ret,maxLen);
        }
        for (int i = 0; i < s2Length; i++) {
            int len = Math.min(s2Length, s1Length - i);
            int maxlen = maxLength(s2, s1, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    private static int maxLength(String s1, String s2, int addA, int addB, int len) {
        int ret = 0 ;
        int k = 0;
        for (int i = 0; i < len;i ++){
            if (s1.charAt(addA+ i) == s2.charAt(addB+ i)){
                k++;
            }else{
                k =0;
            }
            ret = Math.max(ret,k);
        }
        return ret;
    }
}
