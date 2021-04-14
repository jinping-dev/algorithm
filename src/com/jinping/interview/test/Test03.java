package com.jinping.interview.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Test03
 * @Description
 * @Date 2020/12/17 8:47 下午
 * @Created by jinping
 */
public class Test03 {
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();

    private static  int count = 0;
    private static  int sum = 1;
    static class ThreadA extends Thread{
        @Override
        public void run() {
            lock.lock();
            for (int i = 0 ; i < 3;i ++){
                while (count % 2 != 0){
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                count++;
                conditionB.signal();
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            lock.lock();
            for (int i = 0 ; i < 3;i ++){
                while (count % 2 != 1){
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                count++;
                conditionA.signal();
            }
        }
    }


    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();

    }
}


