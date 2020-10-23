package com.jinping.datastruct.queue;

/**
 * @Classname CircleArrayQueueDemo
 * @Description 基于数组定义一个环形队列
 * @Date 2020/10/22 5:37 下午
 * @Created by jinping
 */
public class CircleArrayQueueDemo {
}


class CircleArrayQueue{
    //数组的最大容器
    private int maxSize;
    //front指向队列的第一个元素，也就是说arr[front]指向的是队列的第一个元素
    private int front = 0;
    //rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
    private int rear = 0;
    //该数组用于存放数据，模拟队列
    private int[] arr;

    //创建队列
    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        arr[rear] = data;
        //将rear后移，必须取模
        rear = (rear + 1) % maxSize;

    }

    public int getData(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取到数据");
        }
        //这里需要分析出front指向队列的第一个元素
        // 1.先把front对应的值保存到一个临时变量中
        // 2.将front后移，考虑取模
        // 3.将临时保存的变量返回
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    //显示所有数据
    public void display(){
        if (isEmpty()){
            System.out.println("队列为空，无数据");
            return;
        }
        //从front开始遍历
        for (int i = front; i < front + size(); i ++){
            System.out.printf("arr[%d] = %d \n" ,i % maxSize,arr[i % maxSize]);
        }
    }

    //显示队列头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取到数据");
        }
        return arr[front];
    }

    //求出队列中有效数据的个数
    public int size(){
        return (rear + maxSize - front ) % maxSize;
    }

}