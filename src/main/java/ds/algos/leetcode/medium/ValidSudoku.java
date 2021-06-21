package ds.algos.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /**
     * Input: board =
     * {
     * {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
     * {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
     * {'.', '9', '4', '.', '.', '.', '.', '6', '.'},
     * {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
     * {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
     * {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
     * {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
     * {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
     * {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
     * };
     * Output: true
     */

    public static void main(String[] args) {
        char[][] board =
            {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '4', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '.'}
            };
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku_1(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }

                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }

                int row = i / 3 * 3 + j / 3;
                int col = i % 3 * 3 + j % 3;
                if (board[row][col] != '.' && !boxSet.add(board[row][col])) {
                    return false;
                }

                System.out.printf("row: %s , col: %s", row, col);
                System.out.println();
            }
            System.out.println("--------------------------------");
        }
        return true;
    }

    private static boolean isValidSudoku_1(char[][] board) {
        Set<String> boardSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String val = "(" + board[i][j] + ")";
                    if (!boardSet.add("value " + val + " for a row" + i) ||
                        !boardSet.add("value " + val + " for a column" + j) ||
                        !boardSet.add("value " + val + " for a block" + (i / 3 + "_" + j / 3))
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
