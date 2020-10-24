package com.jinping.datastruct.linkedlist;

/**
 * @Classname HeroNode2
 * @Description 双向链表
 * @Date 2020/10/24 1:33 下午
 * @Created by jinping
 */
public class HeroNode2 {

    public int no;
    public String name;
    public String nickName;
    //指向下一个节点，默认为null
    public HeroNode2 next;
    //指向前一个节点，默认为null
    public HeroNode2 prev;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
