package com.jinping.algorithm.huawei;

/**
 * @Classname MergeArray
 * @Description 合并两个有序数组为一个新的排序好的数组
 * @Date 2020/11/30 5:43 下午
 * @Created by tinner
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6,10,12,16,17};
        int[] nums2 = {2,4,9,100};
        int[] result = merge(nums1,nums2);
        for (int s:result){
            System.out.print(s+",");
        }
    }

    private static int[] merge(int[] nums1,int[]nums2) {
        int[] result =new int[ nums1.length+ nums2.length];
        int nums1_index = 0,nums2_index = 0;
        while (nums1_index < nums1.length || nums2_index < nums2.length){
            if (nums1_index > nums1.length - 1 ){
                result[nums1_index + nums2_index ] = nums2[nums2_index];
                nums2_index ++;
            }else if(nums2_index > nums2.length - 1){
                result[nums1_index + nums2_index] = nums1[nums1_index];
                nums1_index ++;
            }else if (nums1[nums1_index] > nums2[nums2_index]){
                result[nums1_index + nums2_index] = nums2[nums2_index];
                nums2_index ++;
            }else {
                result[nums1_index + nums2_index] = nums1[nums1_index];
                nums1_index ++;
            }
        }
        return result;

    }
}
