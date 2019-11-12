/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int pre2 = 1;
        int pre1 = 1;
        for (int i = 2; i <= n; i++) {
            int num = pre1 + pre2;
            pre2 = pre1;
            pre1 = num;
        }
        return pre1;
    }
}
// @lc code=end

