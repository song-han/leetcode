/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 1) {
            return;
        }
        int radius = (matrix.length + 1) / 2;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int targetI = j;
                int targetJ = matrix.length - i - 1;
                for (int h = 0; h < 3; h++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[targetI][targetJ];
                    matrix[targetI][targetJ] = temp;
                    int originI = targetI;
                    targetI = targetJ;
                    targetJ = matrix.length - originI - 1;
                    
                    
                }
            }
        }
    }
}
// @lc code=end

