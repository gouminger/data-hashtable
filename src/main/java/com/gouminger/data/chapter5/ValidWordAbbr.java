package com.gouminger.data.chapter5;

//单词的唯一缩写
public class ValidWordAbbr {

    /**
     * 单词的 缩写 需要遵循<起始字母><中间字母数><结尾字母> 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。
     * 以下是一些单词缩写的范例：
     * dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母
     * internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母
     * it --> it 单词只有两个字符，它就是它自身的 缩写
     * 实现 ValidWordAbbr 类：
     * ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象
     * boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
     * 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
     * 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。
     */
    public static void main(String[] args) {
        String[] dictionary = new String[]{"deer", "door", "cake", "card"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);
        System.out.println(validWordAbbr.isUnique("dear"));
        System.out.println(validWordAbbr.isUnique("cart"));
        System.out.println(validWordAbbr.isUnique("cane"));
        System.out.println(validWordAbbr.isUnique("make"));
        System.out.println(validWordAbbr.isUnique("cake"));
    }

    private String[] dictionary;
    private String[] abbreviation;

    public ValidWordAbbr(String[] dictionary) {
        this.dictionary = dictionary;
        this.abbreviation = new String[dictionary.length];
        for (int i=0; i<dictionary.length; i++) {
            char[] chars = dictionary[i].toCharArray();
            abbreviation[i] = ""+chars[0]+(chars.length-2)+chars[chars.length-1];
        }
    }

    public boolean isUnique(String word) {
        char[] chars = word.toCharArray();
        String key = ""+chars[0]+(chars.length-2)+chars[chars.length-1];
        boolean result = true;
        for (int i=0; i<this.abbreviation.length; i++) {
            if (key.equals(this.abbreviation[i]) && !word.equals(this.dictionary[i])) {
                result = false;
            }
        }
        return result;
    }
}
