package com.jinping.datastruct.linkedlist;

/**
 * @Classname HeroNode
 * @Description 水浒传英雄排名
 * @Date 2020/10/23 11:46 下午
 * @Created by jinping
 */
public class HeroNode {

    //排名
    public int no;

    public String name;

    public String nickName;

    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
