/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                product *= nums[i - 1];
            }
            result[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                product *= nums[i + 1];
            }
            result[i] *= product;
        }
        return result;
    }
}
// @lc code=end

