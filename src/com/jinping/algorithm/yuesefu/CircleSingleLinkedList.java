package com.jinping.algorithm.yuesefu;

/**
 * @Classname CircleSingleLinkedList
 * @Description 环形链表
 * @Date 2020/10/24 2:29 下午
 * @Created by jinping
 */
public class CircleSingleLinkedList {

    //创建一个first节点，没有编号
    private Boy first = null;

    //添加小孩节点，构成一个环形的链表
    public void addBoy(int nums){

        //数据校验
        if (nums < 1){
            System.out.println("num值不正确");
            return;
        }
        //辅助指针
        Boy currentBoy = null;
        for (int i = 1;i <= nums ; i++){
            //根据编号，构建节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if (i == 1){
                first = boy;
                //构成环
                first.setNext(first);
                //让currentBoy指向第一个小孩
                currentBoy = first;
            }else{
                currentBoy.setNext(boy);
                boy.setNext(first);
                currentBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy(){
        if (first == null){
            System.out.println("没有任何小孩！");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号："+curBoy.getNo());
            if (curBoy.getNext() == first){
                //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//后移
        }
    }

    /**
     *
     * @param startNo 从第几个小孩开始数
     * @param countNum 数到几出列
     * @param nums 最初多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        //对数据进行校验
        if (first == null || startNo < 1 || startNo >nums){
            System.out.println("参数输入错误，请重试");
            return;
        }
        //辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //需求创建一个辅助指针helper，事先应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让firset和helper移动startNo-1次
        for (int j = 0;j<startNo - 1;j ++){
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper == first){//说明圈中只有一个节点
                break;
            }
            //让first和helper指针同时移动，countNum - 1
            for ( int j = 0; j < countNum - 1; j ++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这个时候first指向的节点，就是要出圈的小孩接节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将firset指向小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号为："+ first.getNo());
    }

}
