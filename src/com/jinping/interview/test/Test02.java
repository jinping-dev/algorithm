package com.jinping.interview.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname Test02
 * @Description 两个线程 A，B 同时启动，顺序打印，打印三次
 * @Date 2020/12/17 10:46 上午
 * @Created by jinping
 */
public class Test02 {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            for (int i = 0 ; i < 3;i ++){
                synchronized (lock){
                    System.out.println("A");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }


        });
        Thread t2 = new Thread(()->{
            for (int i = 0 ; i < 3;i ++){
                synchronized (lock){
                    System.out.println("B");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }
        });
        t2.start();
        t1.start();
        countDownLatch.await();
    }
}
