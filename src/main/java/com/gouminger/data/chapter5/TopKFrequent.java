package com.gouminger.data.chapter5;

import java.util.Arrays;

//前 K 个高频元素
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        nums = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        nums = new int[]{5,2,5,3,5,3,1,1,3};
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        nums = new int[]{5,3,1,1,1,3,73,1};
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] keyArray = new int[nums.length];
        int[] cntArray = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (cntArray[j] == 0) {
                    keyArray[j] = nums[i];
                    cntArray[j] = 1;
                    break;
                }
                if (keyArray[j] == nums[i]) {
                    cntArray[j]++;
                    break;
                }
            }
        }
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            int maxKey = -1;
            int maxCnt = -1;
            int maxIdx = -1;
            for (int j=0; j<cntArray.length; j++) {
                if (cntArray[j] == 0) {
                    break;
                }
                if (maxCnt < cntArray[j]) {
                    maxCnt = cntArray[j];
                    maxKey = keyArray[j];
                    maxIdx = j;
                }
            }
            cntArray[maxIdx] = -1;
            result[i] = maxKey;
        }
        return result;
    }
}
