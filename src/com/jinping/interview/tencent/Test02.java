package com.jinping.interview.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Test02
 * @Description
 *2. 用C语言非递归输出由“A-Z“26个字母组成的集合的所有子集
 * @Date 2020/12/23 8:09 下午
 * @Created by jinping
 */
public class Test02 {
    public static void main(String[] args) {
        List<Character> arrayList = new ArrayList<>();
        for(int i = 0 ;i < 3 ; i ++){
            arrayList.add((char) ('A' + i));
        }

        List<List<Character>> print = print(arrayList);
        for (List list: print){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Character>> print(List<Character> arrayList){
        List<List<Character>> result = new ArrayList<>();
        int length = 1 << arrayList.size();
        for(int i = 0 ; i < length; i++){
            int index = 0;
            int k = i;
            List<Character> characters = new ArrayList<>();
            while (k > 0) {
                if ((k & 1 ) > 0){
                    characters.add(arrayList.get(index));
                }
                k >>= 1;
                index ++;
            }
            result.add(characters);
        }
        return result;
    }
}
