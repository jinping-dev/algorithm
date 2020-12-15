package com.jinping.datastruct.linkedlist;


import java.util.Stack;

/**
 * @Classname SingleLinkedListDemo
 * @Description 实现链表中的各个方法，有5个面试题
 * @Date 2020/10/23 11:49 下午
 * @Created by jinping
 */
public class SingleLinkedListDemo {


    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode4);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode2);

        list.update(new HeroNode(3, "小小小", "asd"));
        list.display();

        System.out.println("有效的节点个数为：" + getLength(list.getHead()));
        System.out.println("倒数第2个元素为：" + getLastIndexNode(list.getHead(), 2));
//        reversetList(list.getHead());
//        list.display();

        reversePrint(list.getHead());

        System.out.println("==============合并");
        SingleLinkedList list1 = new SingleLinkedList();
        list1.addByOrder(heroNode1);
        list1.addByOrder(heroNode4);
        SingleLinkedList list2 = new SingleLinkedList();
        list2.addByOrder(heroNode2);
        list2.addByOrder(heroNode3);
        HeroNode result = mergeTwoLists(list1.getHead().next, list2.getHead().next);

        HeroNode temp = result;
        while (true) {
            if (temp == null) {
                break;
            }
//            输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }


    }

    /**
     * 新浪面试题：求出单链表的有效节点个数(如果带头节点的链表，需求不统计头节点)
     *
     * @param heroNode 链表的头节点
     * @return 有效节点个数
     */
    public static int getLength(HeroNode heroNode) {
        if (heroNode.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = heroNode.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }


    /**
     * 查找单链表中倒数第index个节点
     *
     * @param heroNode 头节点
     * @param index    倒数第index的索引
     * @return
     */
    public static HeroNode getLastIndexNode(HeroNode heroNode, int index) {

        //链表为空
        if (heroNode.next == null) {
            return null;
        }
        //链表的有效长度，比如3
        int length = getLength(heroNode);
        //判断
        if (index < 0 || length < index) {
            return null;
        }
        //这个时候temp指向的是第一个元素，如果index为2，就是求倒数第2个元素，也就是正向第2个元素
        HeroNode temp = heroNode.next;
        //那么只需要遍历一次
        for (int i = 0; i < length - index; i++) {
            //遍历一次，指向的就是下一个元素，刚好指向的就是下一个元素（第二个）
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 面试题：将单链表反转
     * head,1，2，4，5，----->head,5，4，2，1
     *
     * @param heroNode
     */
    public static void reversetList(HeroNode heroNode) {
        //如果当前链表为空，或者只有一个节点，无需反转， 直接返回
        if (heroNode.next == null || heroNode.next.next == null) {
            return;
        }
        //定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode current = heroNode.next;
        //指向当前节点[current]的下一个节点,如果不记录，遍历的链表就断掉了
        HeroNode next = null;
        //新的链表头指针
        HeroNode revertsetNode = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，将其取出，并放在新的链表revertsetNode的最前端
        while (current != null) {

            //比如：当前current是1，next存的是2，1->2变为1->null,新的链表：head->1,然后current=2
            //然后2进来了，next存的是3，2->3变为2->1,新的链表:head->2->1。然后current=3

            //先暂时保存当前节点的下一个节点
            next = current.next;
            //将current的下一个节点指向新的链表的最前端
            current.next = revertsetNode.next;
            //将current连接到新的链表上
            revertsetNode.next = current;
            //让current后移
            current = next;
        }
        //将head.next指向revertsetNode.next
        heroNode.next = revertsetNode.next;
    }

    /**
     * 将链表逆序打印
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> nodeStack = new Stack<>();
        HeroNode node = head.next;
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }
        while (nodeStack.size() > 0) {
            System.out.println(nodeStack.pop());
        }
    }



    /**
     * 两个有序的链表，合并成一个新的链表， 依然有序
     * head,1,3,6,7,8
     * head,2,4,9
     */

    public static HeroNode mergeTwoLists(HeroNode l1, HeroNode l2) {
        if(l1 == null && l2==null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        HeroNode node = null;
        if(l1.no > l2.no){
            node = new HeroNode(l2.no,l2.name,l2.nickName);
            node.next = mergeTwoLists(l1,l2.next);
        }else{
            node = new HeroNode(l1.no,l1.name,l1.nickName);
            node.next = mergeTwoLists(l1.next,l2);
        }
        return node;
    }

    public static HeroNode revertTwoList(HeroNode head1, HeroNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //合并后的链表
        HeroNode node = new HeroNode(0, "", "");
        if (head1.next.no > head2.next.no) {
            node.next = head2.next;
            node.next.next = revertTwoList(head1, head2.next);
        } else {
            node.next = head1.next;
            node.next.next = revertTwoList(head1.next, head2);
        }
        return node;

    }


}

class SingleLinkedList {

    //先初始化一个头节点，头节点不动，不放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路：当不考虑编号顺序时，1.找到当前链表的最后节点，2.将最后这个节点的next指向新的节点
    public void add(HeroNode node) {
        //因为header节点不能动，所以我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，则将temp后移
            temp = temp.next;
        }
        //当退出循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = node;
    }

    //第二种方式在添加英雄的时候，根据排名将英雄插入到指定的位置
    //（如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {

        //因为头节点不能动，因此我们仍然通过一个辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//flag标志添加的编号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp的后面插入
                //比如：1，2，5，heroNode的no是4，则2后面指向的是5，需要将4放在2的后面，然后4的next指向5
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明希望添加的node节点编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的英雄的编号" + heroNode.no + "已存在，不能加入");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能修改
    public void update(HeroNode heroNode) {

        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("没有找到这个英雄");
        }
    }

    //删除节点
    public void remove(int no) {
        HeroNode temp = head;
        boolean flag = false;//是否找到
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //1,2,4，5,我需要删除4的话，我需要将4remove掉，2的后驱指向5
                //这个时候是2的节点的next是4
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在");
        }
    }

    //显示链表
    public void display() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
//            输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
