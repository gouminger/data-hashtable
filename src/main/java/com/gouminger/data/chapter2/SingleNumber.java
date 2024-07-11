package com.gouminger.data.chapter2;

//只出现一次的数字
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(singleNumber(nums));

        nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));

        nums = new int[]{1};
        System.out.println(singleNumber(nums));
    }

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     */
    public static int singleNumber(int[] nums) {
        int[] arr = new int[60001];
        for (int n : nums) {
            arr[30000+n] = arr[30000+n]+1;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                return i-30000;
            }
        }
        return -1;
    }
}
