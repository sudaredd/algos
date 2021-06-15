package ds.algos.amazon;

/**
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * https://www.youtube.com/watch?v=X0kX7PMOYi0
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                            {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
                         };
        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "ABCCSE"));
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(i)) {
                    int index = i;
                    return search(board, word, visited, i, j, index);
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length() - 1)
            return true;
        visited[i][j] = true;
        if (i > 0 && visited[i - 1][j] == false && board[i - 1][j] == word.charAt(index + 1)
            && search(board, word, visited, i - 1, j, index + 1)) {
            return true;
        }
        if (j > 0 && visited[i][j - 1] == false && board[i][j - 1] == word.charAt(index + 1)
            && search(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        if (i < board.length - 1 && visited[i + 1][j] == false && board[i + 1][j] == word.charAt(index + 1)
            && search(board, word, visited, i + 1, j, index + 1)) {
            return true;
        }
        if (j < visited[i].length-1 && visited[i][j + 1] == false && board[i][j + 1] == word.charAt(index + 1)
            && search(board, word, visited, i, j + 1, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }


}
