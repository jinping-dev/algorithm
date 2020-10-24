package com.jinping.datastruct.stack;

import java.util.Calendar;

/**
 * @Classname ArrayStack
 * @Description 基于数组实现栈
 * @Date 2020/10/24 3:08 下午
 * @Created by jinping
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;//栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int val){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] = val;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int result = stack[top];
        top --;
        return result;
    }

    //遍历
    public void display(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        for (int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
