package com.gouminger.data.chapter1;

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
