package com.jinping.datastruct.stack;

/**
 * @Classname Test
 * @Description
 * @Date 2020/10/24 3:14 下午
 * @Created by jinping
 */
public class Test {

    public static void main(String[] args) {
        LinkedListStack arrayStack = new LinkedListStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        arrayStack.display();


    }
}
