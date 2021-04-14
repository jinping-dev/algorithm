package com.jinping.interview.youxian;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test01
 * @Description
 * 2 - > 3 ->5
 *            \
 *            \
 *              24->4->5
 *            |
 *          |
 * 5 -> 6
 * @Date 2020/12/29 10:21 上午
 * @Created by jinping
 */
public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(1));
    }

    public static Node process(Node h1,Node h2){
        if (h1 == null || h2 == null){
            return null;
        }
        Node preH1 = h1;
        Node preH2 = h2;
        Node result = null;
        while(preH1 != null || preH2 != null){
            if(preH1 == null){
                preH1 = h2;
            }
            if(preH2 == null){
                preH2 = h1;
            }
            if (preH1 == preH2){
                result = preH1;
                break;
            }
            preH1 = preH1.next;
            preH2 = preH2.next;
        }
        return result;
    }

}

class Node{
    public int val;
    public Node next;
}
