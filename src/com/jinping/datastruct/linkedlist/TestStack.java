package com.jinping.datastruct.linkedlist;

import java.util.Stack;

/**
 * @Classname TestStack
 * @Description 使用栈的方式将链表逆序打印
 * @Date 2020/10/24 1:08 上午
 * @Created by jinping
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("孙悟空");
        stack.add("孙悟饭");
        stack.add("孙悟天");

        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
