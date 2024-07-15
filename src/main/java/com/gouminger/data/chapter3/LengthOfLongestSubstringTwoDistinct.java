package com.gouminger.data.chapter3;

//至多包含两个不同字符的最长子串
public class LengthOfLongestSubstringTwoDistinct {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ababacccccc"));
    }

    /**
     * 给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] arr = s.toCharArray();
        int c1 = -1, c2 = -1, c1Cnt = 0, c2Cnt = 0, left = 0, right = 0, maxLength = 0;
        while (right < arr.length) {
            if (c1 < 0 || c1 == arr[right]) {
                c1 = arr[right];
                c1Cnt++;
            } else if (c2 < 0 || c2 == arr[right]) {
                c2 = arr[right];
                c2Cnt++;
            } else {
                c1 = -1;
                c1Cnt = 0;
                left = right;
                while (left > 0) {
                    left--;
                    if (c1 < 0 || c1 == arr[left]) {
                        c1 = arr[left];
                        c1Cnt++;
                    } else {
                        break;
                    }
                }
                c2 = arr[right];
                c2Cnt = 1;
            }
            maxLength = Math.max(maxLength, c1Cnt+c2Cnt);
            right++;
        }
        return maxLength;
    }
}
