package com.jinping.algorithm.huawei;

/**
 * @Classname MergeArray
 * @Description 合并两个有序数组为一个新的排序好的数组
 * @Date 2020/11/30 5:43 下午
 * @Created by tinner
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        int[] result = merge(nums1,nums2);
        for (int s:result){
            System.out.print(s+",");
        }
    }

    private static int[] merge(int[] nums1,int[]nums2) {
        int[] result =new int[ nums1.length+ nums2.length];
        int nums1Index = 0,nums2Index = 0;
        while (nums1Index < nums1.length || nums2Index < nums2.length){
            if (nums1Index > nums1.length - 1 ){
                result[nums1Index + nums2Index ] = nums2[nums2Index];
                nums2Index ++;
            }else if(nums2Index > nums2.length - 1){
                result[nums1Index + nums2Index] = nums1[nums1Index];
                nums1Index ++;
            }else if (nums1[nums1Index] > nums2[nums2Index]){
                result[nums1Index + nums2Index] = nums2[nums2Index];
                nums2Index ++;
            }else {
                result[nums1Index + nums2Index] = nums1[nums1Index];
                nums1Index ++;
            }
        }
        return result;
    }
}
