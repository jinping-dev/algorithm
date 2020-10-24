package com.jinping.datastruct.stack;

/**
 * @Classname StackNode
 * @Description
 * @Date 2020/10/24 3:20 下午
 * @Created by jinping
 */
public class StackNode {

    public int index;
    public int val;
    public StackNode next;

    public StackNode(int val,int index) {
        this.index = index;
        this.val = val;
    }
}
