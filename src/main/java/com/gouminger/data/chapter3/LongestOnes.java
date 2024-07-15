package com.gouminger.data.chapter3;

//最大连续 1 的个数 III
public class LongestOnes {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));

        nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        k = 3;
        System.out.println(longestOnes(nums, k));
    }

    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     */
    public static int longestOnes(int[] nums, int k) {
        if (nums.length <= k) {
            return k;
        }
        int left = 0, right = 0, count = 0, maxCount = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
            while (right - left + 1 > count + k) {
                if (nums[left++] == 1) {
                    count--;
                }
            }
            right++;
        }
        return Math.min(maxCount + k, nums.length);
    }
}
