package com.gouminger.data.chapter4;

import java.util.Arrays;

//稀疏矩阵的乘法
public class Multiply {

    public static void main(String[] args) {
        int[][] mat1 = new int[][]{{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(Arrays.toString(multiply(mat1, mat2)));
    }

    /**
     * 给定两个稀疏矩阵：大小为 m x k 的稀疏矩阵 mat1 和大小为 k x n 的稀疏矩阵 mat2 ，返回 mat1 x mat2 的结果。你可以假设乘法总是可能的。
     */
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int i=0; i<mat1.length; i++) {
            for (int j=0; j<mat2[0].length; j++) {
                int sum = 0;
                for (int k=0; k<mat1[0].length; k++) {
                    sum += mat1[i][k]*mat2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
