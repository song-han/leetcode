/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            boolean slopeEquals = (y3 - y2) * (x3 - x1) == (y3 - y1) * (x3 - x2);
            if (!slopeEquals) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

