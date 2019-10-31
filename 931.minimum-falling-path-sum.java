/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[] prev = A[0];
        int[] next = new int[n];
        for (int i = 1; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                int min = prev[j];
                if (j - 1 >= 0) {
                    min = Math.min(min, prev[j - 1]);
                }
                if (j + 1 < n) {
                    min = Math.min(min, prev[j + 1]);
                }
                next[j] = min + A[i][j];
            }
            prev = next;
            next = new int[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}
// @lc code=end

