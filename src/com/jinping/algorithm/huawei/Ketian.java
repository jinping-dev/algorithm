package com.jinping.algorithm.huawei;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname Ketian
 * @Description
 * @Date 2020/10/31 3:50 下午
 * @Created by jinping
 */
public class Ketian {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 2");
                try {
                    t1.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        final Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 3");
                try {
                    t2.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");

        //使用 单个任务的线程池来实现。保证线程的依次执行
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.shutdown();
    }
}