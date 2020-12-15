package com.jinping.concurrent;


import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname Damon
 * @Description 测试守护线程
 * @Date 2020/12/7 6:01 下午
 * @Created by tinner
 */
public class Daemon {

    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();

        Thread daemon = new Thread(()->{
            while (true){
                System.out.println("当前线程："+Thread.currentThread().getName() + "正在运行"+ date.getTime());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemon.setDaemon(true);

        Thread anotherThread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"开启");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"结束");
        });
        anotherThread.start();
        daemon.start();
        Thread.sleep(2000);
        Thread anotherThread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"开启");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"结束");
        });
        anotherThread1.start();
        System.out.println("主线程结束");
    }
}
