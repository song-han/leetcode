/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int j = 0; j < coins.length; j++) {
                int c = coins[j];
                int idx = i - c;
                if (idx >= 0 && count[idx] != -1) {
                    int tempCount = count[idx] + 1;
                    min = min == -1 ? tempCount : Math.min(min, tempCount);
                }
            }
            count[i] = min;
        }
        return count[amount];
    }
}
// @lc code=end

