package com.gouminger.data.chapter3;

import java.util.HashMap;
import java.util.Map;

////同构字符串
public class IsIsomorphic {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        System.out.println(isIsomorphic(s, t));

        s = "badc";
        t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    /**
     * 给定两个字符串s和t，判断它们是否是同构的。
     * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Map<Character, Character> leftMap = new HashMap<>();
        Map<Character, Character> rightMap = new HashMap<>();
        for (int i=0; i<arr1.length; i++) {
            if (!leftMap.containsKey(arr1[i]) && !rightMap.containsKey(arr2[i])) {
                leftMap.put(arr1[i], arr2[i]);
                rightMap.put(arr2[i], arr1[i]);
            } else if (!leftMap.containsKey(arr1[i])) {
                return false;
            } else if (!rightMap.containsKey(arr2[i])) {
                return false;
            } else if (leftMap.get(arr1[i]) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
