/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean isEmptyBoard = board.length == 0 || board[0].length == 0;
        if (isEmptyBoard && word.length() == 0) return true;
        if (isEmptyBoard && word.length() != 0) return false; 
        int[][] visisted = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, 0, i, j, visisted)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int idx, int i, int j, int[][] visisted) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visisted[i][j] == 1) {
            return false;
        }
        if (word.charAt(idx) != board[i][j]) {
            return false;
        }
        visisted[i][j] = 1;
        boolean isExisted = exist(board, word, idx + 1, i + 1, j, visisted) || 
               exist(board, word, idx + 1, i, j + 1, visisted) ||
               exist(board, word, idx + 1, i - 1, j, visisted) ||
               exist(board, word, idx + 1, i, j - 1, visisted);
        visisted[i][j] = 0;
        return isExisted;
    }
}
// @lc code=end

