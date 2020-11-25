package com.jinping.datastruct.queue;

/**
 * @Classname MergeArray
 * @Description
 * @Date 2020/11/23 12:01 下午
 * @Created by jinping
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,100};
        int[] nums2 = {2,4,6,7,9,10};
        int[] result = merge(nums1,nums2);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+",");
        }
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int p = 0,q = 0;
        int[] result = new int[nums1.length + nums2.length];
        while (p < nums1.length || q < nums2.length){
            if (nums1.length == p){
                result[p + q] = nums2[q];
                q ++;
            }else if(q == nums2.length){
                result[p + q] = nums1[p];
                p++;
            } else if (nums1[p] < nums2[q]){
                result[p + q] = nums1[p];
                p ++;
            }else{
                result[p + q] = nums2[q];
                q++;
            }
        }
        return result;
    }
}
