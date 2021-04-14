package com.jinping.interview.test;

/**
 * @Classname Test04
 * @Description
 * @Date 2020/12/19 10:09 上午
 * @Created by jinping
 */
public class Test04 {

    public static int num = 0;
    public static void main(String[] args) {
        Test04 test04 = new Test04();
        test04.addno();
        System.out.println(num);
        add();
        System.out.println(num);
    }

    public static synchronized void add(){
        num ++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void addno(){
        num ++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
