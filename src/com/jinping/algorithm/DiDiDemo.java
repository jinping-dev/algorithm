package com.jinping.algorithm;

import java.util.Set;
import java.util.TreeSet;

/**
 * 给一个单词s,和一个字符串集合str。这个单词每次去掉一个字母，直到剩下最后一个字母。求验证是否存在一种删除的顺序，
 * 这个顺序下所有的单词都在str中。例如单词是’abc’，字符串集合是{‘a’,’ab’,’abc’},
 * 如果删除的顺序是’c’,’b’，那么’abc’,’ab’,’a’都在集合中,就符合条件。输出这个组合是否符合条件.
 * <p>
 * 1<=|str[i]|,|s|<=30
 * 1<=str中字符串的个数<=100
 */
public class DiDiDemo {

    static Set<String> map = new TreeSet<String>();

    public static boolean checkWord(String s, String[] str) {
        if (s.length() > str.length) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        return dfs(s, str);
    }

    public static boolean dfs(String s, String[] str) {
        int result = 0;
        //先去遍历整个数组，匹配s和字符串数组中的元素，如果匹配，则设置为1
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(s)) {
                result = 1;
            }
        }
        if (result == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        //当前的子串要没被访问过的
        if (map.contains(s)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) { //删除一个字母后的下一个子串
            String next = s.substring(0, i) + s.substring(i + 1);
            System.out.println(i+"====="+next);
            if (dfs(next, str)) {
                return true;
            }
        }
        //新的子串放入map，为之后子串检查访问情况
        map.add(s);
        System.out.println(map);
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] str = new String[]{"abc","ab","c"};
        System.out.println(checkWord(s, str));
    }

}


