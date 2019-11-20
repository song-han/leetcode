/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[n - 1 - i] = Math.max(right[n - i], height[n - i]);
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            int h = Math.min(left[i], right[i]);
            result += h > height[i] ? h - height[i] : 0;
        }
        return result;
    }
}
// @lc code=end

