/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    pathSum[i][j] = grid[i][j];
                } else if (i == 0) {
                    pathSum[i][j] = pathSum[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    pathSum[i][j] = pathSum[i - 1][j] + grid[i][j];
                } else {
                    pathSum[i][j] = Math.min(pathSum[i][j - 1], pathSum[i - 1][j]) + grid[i][j];
                }
            }
        }
        return pathSum[m - 1][n - 1];
    }
}
// @lc code=end

