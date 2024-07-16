package com.gouminger.data.chapter4;

import java.util.HashSet;
import java.util.Set;

//有效的数独
public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));

        board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));

        board = new char[][]{
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));


    }

    /**
     * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 数字1-9在每一行只能出现一次。
     * 数字1-9在每一列只能出现一次。
     * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
     * 注意：
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用'.'表示。
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];
        int i,j,m;
        for (int k=0; k<81; k++) {
            i = k/9;
            j = k%9;
            //检测行
            if (board[i][j] != '.') {
                if (rows[i] == null) {
                    rows[i] = new HashSet<>();
                }
                if (rows[i].contains(board[i][j])) {
                    return false;
                } else {
                    rows[i].add(board[i][j]);
                }
            }
            //检测列
            if (board[j][i] != '.') {
                if (columns[i] == null) {
                    columns[i] = new HashSet<>();
                }
                if (columns[i].contains(board[j][i])) {
                    return false;
                } else {
                    columns[i].add(board[j][i]);
                }
            }
            //检测田字格
            i = k/3;
            j = k%3;
            m = i/3;
            while (i > 8) {
                i = i-9;
                j = j+3;
            }
            if (board[i][j] != '.') {
                if (squares[m] == null) {
                    squares[m] = new HashSet<>();
                }
                if (squares[m].contains(board[i][j])) {
                    return false;
                } else {
                    squares[m].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
