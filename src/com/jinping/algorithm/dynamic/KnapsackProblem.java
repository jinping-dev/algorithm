package com.jinping.algorithm.dynamic;

/**
 * @Classname KnapsackProblem
 * @Description 背包问题 01背包
 * @Date 2020/10/25 12:31 下午
 * @Created by jinping
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        //物品的重量
        int[] weight = {1,4,3};
        //物品的价值
        int[] value = {1500,3000,2000};
        int m = 4;//背包的容量
        int n = value.length;//物品的个数

        //创建二维数组
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];

        //为了记录放入商品的情况，定义一个二维数组
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列，这里在本程序中可以不去处理，因为默认就是0；
        for (int i = 0;i < v.length;i++){
            v[i][0] = 0;//将第一列设置为0
        }
        for (int j = 0;j < v[0].length;j++){
            v[0][j] = 0;//将第一行 设置为0
        }

        //根据公式动态规划处理
        for (int i = 1;i < v.length;i++){//不处理第一行
            for (int j = 1;j < v[0].length;j++) {//不处理第一列
                if (weight[i - 1] > j){//因为程序中从i开始的
                    v[i][j] = v[i - 1][j];
                }else{
                    if(v[i - 1][j] < value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0;i < v.length;i++){
            for (int j = 0;j < v[i].length;j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("===========");
        int i = path.length - 1; //path行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //逆向遍历
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= weight[i-1]; //w[i-1]
            }
            i--;
        }
    }
}
