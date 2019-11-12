/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Follow up:

// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int preSum = nums[0];
        int max = preSum;
        for (int i = 1; i < len; i++) {
            preSum = Math.max(nums[i], preSum + nums[i]);
            max = Math.max(preSum, max);
        }
        return max;
    }
}
// @lc code=end

