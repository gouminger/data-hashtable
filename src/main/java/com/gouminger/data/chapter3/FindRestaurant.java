package com.gouminger.data.chapter3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两个列表的最小索引总和
public class FindRestaurant {

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

        list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        list2 = new String[]{"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    /**
     * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<list1.length;i++) {
            map.put(list1[i], i);
        }
        int sum = Integer.MAX_VALUE, t;
        StringBuilder res = new StringBuilder();
        for (int i=0;i<list2.length;i++) {
            if (!map.containsKey(list2[i])) {
                continue;
            }
            t = map.get(list2[i])+i;
            if (t < sum) {
                res = new StringBuilder(list2[i]);
                sum = t;
            } else if (t == sum) {
                res.append(";").append(list2[i]);
            }
        }
        return res.toString().split(";");
    }
}
