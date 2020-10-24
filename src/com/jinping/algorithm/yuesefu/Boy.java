package com.jinping.algorithm.yuesefu;

/**
 * @Classname Boy
 * @Description 约瑟夫的节点
 * @Date 2020/10/24 2:28 下午
 * @Created by jinping
 */
public class Boy {

    //编号
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
