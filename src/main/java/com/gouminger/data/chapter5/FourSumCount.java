package com.gouminger.data.chapter5;

import java.util.HashMap;
import java.util.Map;

//四数相加 II
public class FourSumCount {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            for (int value : nums2) {
                map.compute(j + value, (k, v) -> {
                    if (v == null) {
                        return 1;
                    }
                    return v + 1;
                });
            }
        }

        int result = 0;
        for (int j : nums3) {
            for (int value : nums4) {
                Integer cnt = map.get(-j-value);
                if (cnt != null) {
                    result+=cnt;
                }
            }
        }
        return result;
    }
}
