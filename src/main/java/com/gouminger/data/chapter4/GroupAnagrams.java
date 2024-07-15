package com.gouminger.data.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//字母异位词分组
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

        strs = new String[]{""};
        System.out.println(groupAnagrams(strs));

        strs = new String[]{"a"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        char[] arr;
        for (String str : strs) {
            arr = str.toCharArray();
            String k = sort(arr);
            if (result.containsKey(k)) {
                result.get(k).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                result.put(k, l);
            }
        }
        List<List<String>> list = new ArrayList<>(result.values());
        return list;
    }

    private static String sort (char[] arr) {
        char t;
        for (int i=0; i< arr.length; i++) {
            for (int j=i+1; j< arr.length; j++) {
                if (arr[i] > arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return new String(arr);
    }
}
