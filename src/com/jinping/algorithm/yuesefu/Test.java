package com.jinping.algorithm.yuesefu;

/**
 * @Classname Test
 * @Description
 * @Date 2020/10/24 2:41 下午
 * @Created by jinping
 */
public class Test {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //测试
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
