package com.jinping.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 *  这是一道华为的笔试题：
 *  输入一个二维数组：
 *  1,2
 *  3,4
 *  两个数组的长度相同均为N，N<=5000,第一行为N1，第二行为N2,
 *  N1和N2的元素可以自由交换，交换之后的N1的和与N2的和的差值要最小
 *  比如上述数字输出为：0
 *  5，15，20
 *  25，20，30
 *  应该输出：5
 *
 * @Auhor: jinping
 * @Date: 2019/12/12 11:50 上午
 */
public class HuaweiTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        List<Integer> list1 = new ArrayList<>();
        //初始化
        String[] sp1 = s1.split(",");
        String[] sp2 = s2.split(",");
        for (String int1 : sp1) {
            list1.add(Integer.parseInt(int1));
        }
        if (list1.size() > 5000) {
            return;
        }
        for (String int2 : sp2) {
            list1.add(Integer.parseInt(int2));
        }
        //排序
        Collections.sort(list1);
        if (list1.size() > 3) {
            //去重
            List<Integer> list2 = new ArrayList<>();
            for (Integer num : list1) {
                if (!list2.contains(num)) {
                    list2.add(num);
                }
            }
            while (list2.size() > 3) {
                int dele = list2.get(list2.size() - 1) - list2.get(list2.size() - 2);
                list2 = newArray(list2, dele);
            }
            System.out.println(Math.abs(list2.get(0) + list2.get(1) - list2.get(2)));
        } else if (list1.size() == 2) {
            System.out.println(Math.abs(list1.get(0) - list1.get(1)));
        }
    }

    public static List<Integer> newArray(List<Integer> list1, int temp) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < list1.size() - 2; i++) {
            list.add(list1.get(i));
        }
        list.add(temp);
        //排序
        Collections.sort(list);
        return list;
    }
}
