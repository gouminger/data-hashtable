package com.gouminger.data.chapter1;

/**
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class MyHashSet {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1000000);
        System.out.println(set.contains(108));
        set.remove(108);
        System.out.println(set.contains(108));
    }

    private int[][] arr;

    public MyHashSet() {
        arr = new int[1001][1000];
    }

    public void add(int key) {
        arr[key/1000][key%1000] = 1;
    }

    public void remove(int key) {
        arr[key/1000][key%1000] = 0;
    }

    public boolean contains(int key) {
        return arr[key/1000][key%1000] > 0;
    }

}
