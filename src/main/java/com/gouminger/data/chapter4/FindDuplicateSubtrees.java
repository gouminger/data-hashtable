package com.gouminger.data.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//寻找重复的子树
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        List<TreeNode> res = findDuplicateSubtrees(root);
        System.out.println(res);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        List<TreeNode> res2 = findDuplicateSubtrees(root2);
        System.out.println(res2);

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.right.left = new TreeNode(3);
        List<TreeNode> res3 = findDuplicateSubtrees(root3);
        System.out.println(res3);
    }

    /**
     * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
     * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
     * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        scanNode(root, map, list);
        return list;
    }

    public static String scanNode(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null) {
            return "(*)";
        }
        String left = scanNode(node.left, map, list);
        String right = scanNode(node.right, map, list);
        String cur = "("+left+node.val+right+")";
        if (map.get(cur) == null) {
            map.put(cur, 1);
        } else if (map.get(cur) == 1) {
            list.add(node);
            map.put(cur, 2);
        }
        return cur;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
