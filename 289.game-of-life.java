/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
  
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int l = lives(board, m, n, i, j);
                if (board[i][j] == 1 && (l == 2 || l == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && l == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int lives(int[][] board, int m, int n, int i, int j) {
        int l = 0;
        for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++) {
                l += board[x][y] & 1;
            }
        }
        l -= board[i][j];
        return l;
    }

}
// @lc code=end

