package com.gouminger.data.chapter5;

public class TwoSum {

    private int[] nums;

    private int idx;

    public TwoSum() {
        nums = new int[10000];
        idx = 0;
    }

    public void add(int number) {
        nums[idx++] = number;
    }

    public boolean find(int value) {
        if (value < -100000 || value > 100000) {
            return false;
        }
        for (int i=0; i<idx; i++) {
            for (int j=i+1; j<idx; j++) {
                if (nums[i] + nums[j] == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
