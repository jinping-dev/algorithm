package com.jinping.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Test01
 * @Description 使用lock实现多线程同步
 * @Date 2020/12/8 3:01 下午
 * @Created by tinner
 */
public class Test01 {

    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(Test01::testSync);

        Thread t2 = new Thread(Test01::testSync);
        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();

    }

    public static void testSync(){
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
