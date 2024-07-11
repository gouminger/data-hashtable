package com.gouminger.data.chapter1;

public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));   // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }

    private int[][] arr;

    public MyHashMap() {
        arr = new int[1001][1000];
        for (int i=0;i<1001;i++) {
            for (int j=0;j<1000;j++) {
                arr[i][j] = -1;
            }
        }
    }

    public void put(int key, int value) {
        arr[key/1000][key%1000] = value;
    }

    public int get(int key) {
        return arr[key/1000][key%1000];
    }

    public void remove(int key) {
        arr[key/1000][key%1000] = -1;
    }

}
