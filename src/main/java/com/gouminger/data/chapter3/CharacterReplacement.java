package com.gouminger.data.chapter3;

//替换后的最长重复字符
public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));

        s = "AABABBA";
        k = 1;
        System.out.println(characterReplacement(s, k));

        s = "ABBB";
        k = 2;
        System.out.println(characterReplacement(s, k));

        s = "ABCDDD";
        k = 3;
        System.out.println(characterReplacement(s, k));

        s = "ABAA";
        k = 0;
        System.out.println(characterReplacement(s, k));
    }

    /**
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
     */
    public static int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int left = 0, right = 0, i = 0, maxCount = 0;
        while (right < arr.length) {
            i = arr[right]-'A';
            freq[i]++;
            maxCount = Math.max(maxCount, freq[i]);
            while (right - left + 1 > maxCount + k) {
                freq[arr[left++]-'A']--;
            }
            right++;
        }
        return Math.min(maxCount + k, arr.length);
    }

}
