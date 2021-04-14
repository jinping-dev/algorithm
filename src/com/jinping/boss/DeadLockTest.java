package com.jinping.boss;

/**
 * @Author: jinping
 * @DATE: 2021/4/7 22:51
 * @Description 测试死锁
 **/
public class DeadLockTest {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void m1(){
        new Thread(()->{
            System.out.println("梭子1");
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + "。。。获得了锁1");
                try {
                    Thread.sleep(2000);
                    System.out.println("梭子1解除了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + "。。。获得了锁2");
                }
            }
        },"thread 1").start();

        new Thread(()->{
            System.out.println("梭子2");

            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + "。。。获得了锁2");
                try {
                    Thread.sleep(10);
                    System.out.println("梭子2解除了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + "。。。获得了锁1");
                }
            }
        },"thread 2").start();
    }
    public static void main(String[] args) {
        m1();

    }
}
