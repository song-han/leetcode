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
        // return solution1(nums);
        return solution2(nums);
    }

    private int solution1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private int solution2(int[] nums) {
        // 子序列肯定以数列中某个元素作为结尾
        // 那我们先求以某个元素结尾的所有子序列的最大和
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre = nums[i];
            } else {
                if (pre >= 0) {
                    pre += nums[i];
                } else {
                    pre = nums[i];
                }
            }
            max = Math.max(max, pre);
        }
        return max;
    }

    private int solution3(int[] nums) {
        // 分治法
        return 0;
    }
}
// @lc code=end

