package com.gouminger.data.chapter3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两数之和
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 3};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int a;
        for (int i=0; i<nums.length; i++) {
            a = nums[i];
            if (map.containsKey(target-a)) {
                return new int[]{i, map.get(target-a)};
            } else {
                map.put(a, i);
            }
        }
        return null;
    }
}
