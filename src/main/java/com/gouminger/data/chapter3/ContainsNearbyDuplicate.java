package com.gouminger.data.chapter3;

import java.util.HashSet;
import java.util.Set;

//存在重复元素 II
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    /**
     * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
     * 如果存在，返回 true ；否则，返回 false 。
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (set.size() <= k) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
                continue;
            }
            set.remove(nums[i-k-1]);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
