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
        if (s.length() <= k) {
            return k;
        }
        char[] arr = s.toCharArray();
        int result = 0;
        int windowL = 0, windowR = 0, windowValue = arr[0];
        int tempK = k, tempResult;
        boolean hasNext = false;
        int nextWindowL = 0, nextWindowR = 0, nextWindowValue = arr[0];

        while (true) {
            if (windowR+1 < arr.length) {
                //判断窗口是否可右扩
                if (windowValue == arr[windowR+1]) {
                    windowR++;
                    continue;
                }
                if (!hasNext) {
                    nextWindowL = windowR+1;
                    nextWindowR = windowR+1;
                    nextWindowValue = arr[windowR+1];
                    hasNext = true;
                }
                if (tempK > 0) {
                    tempK--;
                    windowR++;
                    continue;
                }
                tempResult = windowR - windowL + 1;
                if (tempResult > result) {
                    result = tempResult;
                }
                if (hasNext) {
                    windowL = nextWindowL;
                    windowR = nextWindowR;
                    windowValue = nextWindowValue;
                    tempK = k;
                    hasNext = false;
                    continue;
                }
                break;
            } else if (windowL > 0) {
                //判断窗口是否可左扩
                if (windowValue == arr[windowL - 1]) {
                    windowL--;
                    continue;
                } else if (tempK > 0) {
                    tempK--;
                    windowL--;
                    continue;
                }
                tempResult = windowR - windowL + 1;
                if (tempResult > result) {
                    result = tempResult;
                }
                if (hasNext) {
                    windowL = nextWindowL;
                    windowR = nextWindowR;
                    windowValue = nextWindowValue;
                    tempK = k;
                    hasNext = false;
                    continue;
                }
                break;
            } else {
                tempResult = windowR - windowL + 1;
                if (tempResult > result) {
                    result = tempResult;
                }
                if (hasNext) {
                    windowL = nextWindowL;
                    windowR = nextWindowR;
                    windowValue = nextWindowValue;
                    tempK = k;
                    hasNext = false;
                    continue;
                }
                break;
            }
        }
        tempResult = windowR-windowL+1;
        if (tempResult > result) {
            result = tempResult;
        }
        return result;
    }
}
