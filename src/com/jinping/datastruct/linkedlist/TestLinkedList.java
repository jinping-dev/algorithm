package com.jinping.datastruct.linkedlist;

import java.util.Stack;

/**
 * @Classname TestLink
 * @Description
 * @Date 2020/12/13 7:57 下午
 * @Created by jinping
 */
public class TestLinkedList {

    //头节点
    private static Node head = new Node(0);

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        addByOrder(node1);
        addByOrder(node2);
        addByOrder(node4);
        addByOrder(node3);
        addByOrder(node5);

        display(head);

//        modifyNumber(5,100);
//        display(head);
//        System.out.println("删除节点之前的长度为："+length(head));
//
//        delete(3);
//        display(head);
//
//        System.out.println("删除节点之后的长度为："+length(head));

//        Node revertNode = revert(head);
//        display(revertNode);

//        revertPrint(head);

        printDigui(head);

    }

    /**
     * 向链表中添加元素
     * @param node
     */
    public static void add(Node node){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按照元素大小值排列添加元素
     * @param node
     */
    public static void addByOrder(Node node){
        boolean flag = false;
        Node temp = head;
        while (temp.next != null){
            if (temp.next.number > node.number){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            Node nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;
        }else{
            temp.next = node;
        }
    }

    /**
     * 打印链表中的元素
     * @param node
     */
    public static void display(Node node){
        if (node == null){
            System.out.println("链表为空");
        }
        Node temp = node.next;
        while (temp != null ){
            System.out.print(temp.number + ",");
            temp = temp.next;
        }
        System.out.println();
    }


    /**
     * 修改链表中指定索引的node的值
     * @param index 要修改的索引下标
     * @param newNum 需要修改的新值
     */
    public static void modifyNumber(int index ,int newNum){
        Node temp = head;
        int indexSum = 1;
        while (temp.next != null){
            if (index == indexSum){
               temp.next.number = newNum;
               break;
            }
            indexSum ++;
            temp = temp.next;
        }
    }

    /**
     * 删除一个node
     * @param index 需要删除的索引下标
     */
    public static void delete(int index){
        Node temp = head;
        int indexSum = 1;
        while (temp.next != null){
            if (index == indexSum){
                temp.next = temp.next.next;
                break;
            }
            indexSum ++;
            temp = temp.next;
        }
    }


    /**
     * 计算链表的长度
     * @param node
     * @return
     */
    public static int length(Node node){
        int result = 0;
        while (node.next != null){
            result++;
            node = node.next;
        }
        return result;
    }

    /**
     * 将链表反转
     * @return
     */
    public static Node revert(Node node){
        if (node.next == null){
            return null;
        }
        Node revertNode = new Node(0);
        Node cur = node.next;
        Node next = null;
        while (cur!=null){
            //1.保存下一个节点指针
            next = cur.next;
            //2.将当前节点的下一个节点指向新节点的下一个节点
            cur.next = revertNode.next;
            //3.新节点的下一个节点指向当前节点
            revertNode.next = cur;
            //4.当前节点为下一个节点，继续执行循环
            cur = next;
        }
        return revertNode;
    }

    /**
     * 将链表反向打印（stack方式）
     */
    public static void revertPrint(Node node){
        Node temp = node.next;
        Stack<Node> stack = new Stack<>();
        while (temp!= null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0){
            Node pop = stack.pop();
            System.out.println(pop.number);
        }
    }

    public static void printDigui(Node node){
        if (node.number != 0) {
            System.out.println(node.number);
        }
        if (node.next != null){
            printDigui(node.next);
        }
    }

}
