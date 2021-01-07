package com.jinping.boss;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname PrintABC
 * @Description PrintABC
 * @Date 2020/12/23 5:16 下午
 * @Created by tinner
 */
public class PrintABC {

    public static void main(String[] args) throws InterruptedException {
        PrintMehtod printMehtod = new PrintMehtod();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            try {
                printMehtod.printA();
            }finally {
                countDownLatch.countDown();
            }
        }).start();
        new Thread(()->{
            try {
                printMehtod.printB();
            }finally {
                countDownLatch.countDown();
            }
        }).start();
        new Thread(()->{
            try {
                printMehtod.printC();
            }finally {
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
    }

}

class PrintMehtod {
    private Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    int number = 1;

    void printA() {
        lock.lock();
        try {
            if (number != 1) {
                conditionA.await();
            }
            System.out.print("A");
            number = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    void printB() {
        lock.lock();
        try {
            if (number != 2) {
                conditionB.await();
            }
            System.out.print("B");
            number = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    void printC() {
        lock.lock();
        try {
            if (number != 3) {
                conditionC.await();
            }
            System.out.print("C");
            number = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
