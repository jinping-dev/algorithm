package com.jinping.concurrent;

import sun.applet.Main;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jinping
 * @DATE: 2020/11/27 0:00
 * @Description pahser
 **/
public class TestPhaser {
    static Random random = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();

    static void milliSleep(int milli) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            TimeUnit.MICROSECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i ++){
            new Thread(new Person("p"+i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

    }

    static class MarriagePhaser extends Phaser {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了！ " + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人都吃完了！ " + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人都离开了！ " + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束了！新郎新娘xxxx " + registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }


    static class Person implements Runnable{

        String name;


        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
            phaser.arriveAndAwaitAdvance();
        }
        public void eat() {
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 吃完！\n", name);
            phaser.arriveAndAwaitAdvance();
        }
        public void leave() {
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        private void hug(){
            if (name.equals("新郎")|| name.equals("新娘")){
                milliSleep(random.nextInt(1000));
                System.out.printf("%s 洞房！\n", name);
                phaser.arriveAndAwaitAdvance();
            }else{
                phaser.arriveAndAwaitAdvance();
            }
        }


        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }


}
