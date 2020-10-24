package com.jinping.datastruct.linkedlist;

/**
 * @Classname DoubleLinkedListDemo
 * @Description 双向链表
 * @Date 2020/10/24 1:35 下午
 * @Created by jinping
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList list = new DoubleLinkedList();
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode4);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode2);

        list.update(new HeroNode2(3, "小小小", "asd"));
        list.display();

    }
}

class DoubleLinkedList{
    //先初始化一个头节点，头节点不动，不存放具体数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void display(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        //因为头节点，不能动，所以需要辅助变量指针去遍历
        HeroNode2 temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加元素到尾结点
    public void add(HeroNode2 node){
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，temp后移
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    //更新某个元素
    public void update(HeroNode2 heroNode){

        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if (temp.next == null){
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else{
            System.out.println("没有找到此节点");
        }
    }

    //从双向链表中删除节点
    //1.对于双向链表，我们可以直接找到要删除的这个节点
    //2.找到后，自我删除即可
    public void del(int no){

        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if (temp.next == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.prev.next = temp.next;
            if (head.next != null){
                temp.next.prev = temp.prev;
            }
        }else{
            System.out.println("未找到元素");
        }
    }

    //按照编号顺序去添加
    public void addByOrder(HeroNode2 hero){

        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null ){
                break;
            }
            if(temp.next.no > hero.no){
                break;
            }else if(temp.next.no == hero.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("编号已存在，插入失败");
        }else{
            if(temp.next != null){
                temp.next.prev = hero;
                hero.next = temp.next;
            }
            temp.next = hero;
            hero.prev = temp;
        }
    }
}
