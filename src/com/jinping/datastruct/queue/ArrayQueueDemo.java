package com.jinping.datastruct.queue;

import java.util.Scanner;

/**
 * @Classname ArrayQueueDemo
 * @Description 基于数组定义一个队列
 * @Date 2020/10/22 5:19 下午
 * @Created by jinping
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
    }
}

class ArrayQueue{
    //数组的最大容器
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据，模拟队列
    private int[] arr;

    //创建队列
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addData(int data){
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear ++;
        arr[rear] = data;
    }

    public int getData(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取到数据");
        }
        front ++;
        return arr[front];
    }

    //显示所有数据
    public void display(){
        if (isEmpty()){
            System.out.println("队列为空，无数据");
            return;
        }
        for (int i = 0; i <arr.length; i ++){
            System.out.printf("arr[%d] = %d \n" ,i,arr[i]);
        }
    }

    //显示队列头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取到数据");
        }
        return arr[front + 1];
    }
}