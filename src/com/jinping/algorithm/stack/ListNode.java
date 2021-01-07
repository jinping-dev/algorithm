package com.jinping.algorithm.stack;

import java.util.Stack;

/**
 * @Classname ListNode
 * @Description 用两个栈实现一个先进先出的队列
 * @Date 2021/1/5 3:08 下午
 * @Created by jinping
 */
public class ListNode {
    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();

    public void push(String str) {
        stack1.push(str);
    }

    public String pop() {
        if(stack2.size() == 0) {
            while(!stack1.isEmpty()) {
                String temp = stack1.peek();
                stack2.push(temp);
                stack1.pop();
            }
        }
        String res = stack2.peek();
        stack2.pop();
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.push("jinping");
        listNode.push("size");
        String pop = listNode.pop();
        System.out.println(pop);
    }
}

