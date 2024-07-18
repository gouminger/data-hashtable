package com.gouminger.data.chapter5;

//宝石与石头
public class NumJewelsInStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String tones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, tones));

        jewels = "z";
        tones = "ZZ";
        System.out.println(numJewelsInStones(jewels, tones));
    }

    /**
     * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
     * stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int[] arrs = new int['z'-'A'+1];
        for (char c : jewels.toCharArray()) {
            arrs[c-'A'] = 1;
        }
        int sum = 0;
        for (char c : stones.toCharArray()) {
            if (arrs[c-'A'] == 1) {
                sum++;
            }
        }
        return sum;
    }
}
