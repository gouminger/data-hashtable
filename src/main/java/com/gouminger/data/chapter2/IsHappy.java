package com.gouminger.data.chapter2;

import java.util.HashSet;
import java.util.Set;

//快乐数
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     */
    public static boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        int i,t=0;
        while (true) {
            i = n%10;
            t += i*i;
            n = n/10;
            if (n==0) {
                if (t == 1) {
                    return true;
                } else if (sums.contains(t)) {
                    return false;
                } else {
                    sums.add(t);
                    n=t;
                    t=0;
                }
            }
        }
    }
}
