package com.jinping.algorithm;

import java.util.*;

/**
 * N叉树
 * 给定一个N叉树，求出这个N叉树的第N层的第M节点的值
 * 数据结构的定义见Node
 */
public class NxTreeSolution {

    /**
     * 广度优先搜索
     * @param root 目标N叉树
     * @return 返回一个双层list的列表，外层list的长度为树的深度，内层list的长度为每层的节点个数
     */
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每一层的list
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //使用poll()来获取并移出元素
                Node node = queue.poll();
                level.add(node.getVal());
                if (node.getChildren() != null ){
                    queue.addAll(node.getChildren());
                }
            }
            result.add(level);
        }
        return result;
    }

    public static int search(List<List<Integer>> list,int floor,int nextNum){
        List<Integer> integerList = list.get(floor-1);
        return integerList.get(nextNum-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //样例输入:1,null,3,2,4,null,5,6
        System.out.println("第几层：");
        int floor = scanner.nextInt();
        System.out.println("第几个：");
        int nextNum = scanner.nextInt();
        //[1],[3,2,4],[5,6]
        Node root = new Node(1);
        Node ch1 = new Node(3);
        Node ch2 = new Node(2);
        Node ch3 = new Node(4);
        Node ch4 = new Node(5);
        Node ch5 = new Node(6);
        List<Node> children2 = new ArrayList<>();
        children2.add(ch4);
        children2.add(ch5);
        ch1.setChildren(children2);
        List<Node> children1 = new ArrayList<>();
        children1.add(ch1);
        children1.add(ch2);
        children1.add(ch3);
        root.setChildren(children1);

        //先获取到广度优先搜索得到的list
        List<List<Integer>> lists = levelOrder(root);
        //再进行查找
        int search = search(lists, floor, nextNum);
        System.out.println("想要得到的值为:"+ search);
    }
}
class Node{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}

