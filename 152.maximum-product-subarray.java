/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[][] results = new int[nums.length][2];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                results[0][0] = nums[0];
                results[0][1] = nums[0];
            } else {
                int min = results[i - 1][0];
                int max = results[i - 1][1];
                if (nums[i] >= 0) {
                    results[i][1] = Math.max(max * nums[i], nums[i]);
                    results[i][0] = Math.min(min * nums[i], nums[i]);
                } else {
                    results[i][1] = Math.max(min * nums[i], nums[i]);
                    results[i][0] = Math.min(max * nums[i], nums[i]);
                }
            }
            result = Math.max(results[i][1], result);
        }
        return result;
    }
}
// @lc code=end

