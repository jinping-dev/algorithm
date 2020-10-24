package com.jinping.datastruct.stack;

/**
 * @Classname LinkedListStack
 * @Description
 * @Date 2020/10/24 3:20 下午
 * @Created by jinping
 */
public class LinkedListStack {
    private int maxSize;
    private StackNode stackNode;
    private int top = -1;//栈顶，初始化为-1

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        stackNode = new StackNode(-1,top);
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //栈空
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
        stackNode.next = new StackNode(val,top);
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        StackNode temp = stackNode;
        while (true){
            if (temp.index == top){
                break;
            }
            temp = temp.next;
        }
        int num = temp.val;
        top --;
        temp.next = null;
        return num;
    }

    //遍历
    public void display(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        StackNode temp = stackNode;
        while (true){
            System.out.printf("stack[%d]=%d\n",top,temp.val);
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }

}
