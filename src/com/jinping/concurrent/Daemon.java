package com.jinping.concurrent;


import java.util.Timer;

/**
 * @Classname Damon
 * @Description Damon
 * @Date 2020/12/7 6:01 下午
 * @Created by tinner
 */
public class Daemon {

    public static void main(String[] args) throws InterruptedException {

        Thread daemon = new Thread(()->{
            while (true){
                System.out.println("当前线程："+Thread.currentThread().getName() + "正在运行"+ System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(5000);
        System.out.println("主线程结束");
    }
}
