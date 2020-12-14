package com.jinping.aliyun;

/**
 * @Author: jinping
 * @DATE: 2020/12/11 22:23
 * @Description 链表两两反转
 **/
public class NodeDemo {

    public static void main(String[] args) {

        SingleList list = new SingleList();
        for (int i = 1 ; i <= 5 ;i++){
            Node node = new Node(i);
            list.add(node);
        }
        System.out.println("反转前：");
        list.display();
        System.out.println();
        System.out.println("反转后：");
        revertNode(list.getHead());
        list.display();
    }

    /**
     * 链表两两反转
     * @param node
     * @return
     */
    public static Node revertNode(Node node){
        Node head = node;
        while(head.next != null && head.next.next != null){
            // 开始反转
            Node next1 = head.next;
            Node next2 = next1.next;
            head.next = next2;
            next1.next = next2.next;
            next2.next = next1;
            // dummy 指针前移
            head = next1;
        }
        return head;
    }
}


class SingleList {

    private Node head = new Node(null);

    public Node getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * @param node
     */
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 输出链表
     */
    public void display() {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next!= null){
                System.out.print(temp.num + "->");
            }else{
                System.out.print(temp.num);
            }
            temp = temp.next;
        }
    }

}

class Node {
    public Integer num;
    public Node next;

    public Node(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }
}

