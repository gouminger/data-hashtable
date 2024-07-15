package com.gouminger.data.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//移位字符串分组
public class GroupStrings {

    public static void main(String[] args) {
        System.out.println(groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}));
        System.out.println(groupStrings(new String[]{"a"}));
    }

    /**
     * 对字符串进行 “移位” 的操作：
     * 右移：将字符串中每个字母都变为其在字母表中 后续 的字母，其中用 'a' 替换 'z'。比如，"abc"能够右移为"bcd"，"xyz"能够右移为"yza"。
     * 左移：将字符串中每个字母都变为其在字母表中 之前的字母，其中用 'z' 替换 'a'。比如，"bcd"能够左移为"abc"，"yza"能够左移为"xyz"。
     * 我们可以不断地向两个方向移动字符串，形成 无限的移位序列。
     * 例如，移动"abc"来形成序列：... <-> "abc" <-> "bcd" <-> ... <-> "xyz" <-> "yza" <-> ... <-> "zab" <-> "abc" <-> ...
     * 给定一个字符串数组strings，将属于相同移位序列的所有strings[i]进行分组。你可以以 任意顺序 返回答案。
     */
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        String k;
        for (String s : strings) {
            k = buildKey(s);
            if (map.containsKey(k)) {
                map.get(k).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(k, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String buildKey (String s) {
        char[] chars = s.toCharArray();
        int f = chars[0]-'a';
        for (int i=0; i<chars.length; i++) {
            chars[i] = (char) (chars[i]-f);
            if (chars[i] < 'a') {
                chars[i] = (char) (chars[i]+26);
            }
        }
        return new String(chars);
    }
}
