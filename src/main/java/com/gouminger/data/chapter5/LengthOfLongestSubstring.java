package com.gouminger.data.chapter5;

import java.util.HashSet;
import java.util.Set;

//无重复字符的最长子串
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(lengthOfLongestSubstring(s));
        s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     */
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxCount = 0;
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while (j < arr.length) {
            if (!set.contains(arr[j])) {
                set.add(arr[j]);
                j++;
                continue;
            }
            maxCount = Math.max(maxCount, j-i);
            while (i < arr.length) {
                if (arr[i] != arr[j]) {
                    set.remove(arr[i]);
                    i++;
                    continue;
                }
                i++;
                break;
            }
            set.add(arr[j]);
            j++;
        }
        maxCount = Math.max(maxCount, j-i);
        return maxCount;
    }
}
