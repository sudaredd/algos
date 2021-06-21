package ds.algos.amazon;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Input: board =
 {
 {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
 {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
 {'.', '9', '4', '.', '.', '.', '.', '6', '.'},
 {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
 {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
 {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
 {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
 {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
 {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
 };
 * Output: true
 */
public class ValidSudoku {

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
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku_1(board));
        System.out.println(isValidSudoku_2(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set seen = new LinkedHashSet();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char val = board[row][col];
                if (val != '.') {
                    String v = "(" + val + ")";
                    if (!seen.add(row + v) || !seen.add(v + col) || !seen.add(row / 3 + v + col / 3)) {
                        System.out.println(seen);
                        return false;
                    }
                }
            }
        }
//        System.out.println(seen);
        return true;
    }

    public static boolean isValidSudoku_1(char[][] board) {
        Set seen = new LinkedHashSet();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char val = board[row][col];
                if (val != '.') {
                    String v = "(" + val + ")";
                    if (!seen.add(v + " In a row " + row) ||
                        !seen.add(v + " In  a col " + col) ||
                        !seen.add(v + " In a Block " + row / 3 + "_" + col / 3)
                    ) {
                        System.out.println(seen);
                        return false;
                    }
                }
            }
        }
        System.out.println(seen);
        return true;
    }

    public static boolean isValidSudoku_2(char[][] board) {

        for (int i = 0; i < 9; i++) {
            boolean row[] = new boolean[9];
            boolean col[] = new boolean[9];
            boolean block[] = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!row[board[i][j] - '1']) {
                        row[board[i][j] - '1'] = true;
                    } else {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!col[board[j][i] - '1']) {
                        col[board[j][i] - '1'] = true;
                    } else {
                        return false;
                    }
                }
                int r = i / 3 * 3 + j / 3;
                int c = i % 3 * 3 + j % 3;
                if (board[r][c] != '.') {
                    if (!block[board[r][c] - '1']) {
                        block[board[r][c] - '1'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
