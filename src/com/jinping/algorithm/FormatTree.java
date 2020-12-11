package com.jinping.algorithm;

import com.jinping.algorithm.tree.TreeNode;

import java.util.LinkedList;

/**
 * 遍历二叉树
 * 先序   根左右
 * 中序   左根右
 * 后序   左右根
 * 层序
 */
public class FormatTree {

    /**
     * 初始化数据
     * @param list
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list){

        TreeNode node = null ;
        if (list == null || list.isEmpty()){
            return null;
        }
        //LinkedList内部提供的api，移除并获取第一个元素
        Integer data = list.removeFirst();
        if (data != null ){
            node = new TreeNode(data);
            node.setLeftChild(createBinaryTree(list));
            node.setRightChild(createBinaryTree(list));
        }
        return node;
    }

    /**
     * 二叉树前序遍历   根-> 左-> 右
     * @param tree    二叉树节点
     */
    public static void preOrderTraveral(TreeNode tree){
        if (tree == null ){
            return;
        }
        System.out.println(tree.getData() + " ");
        preOrderTraveral(tree.getLeftChild());
        preOrderTraveral(tree.getRightChild());
    }
}
