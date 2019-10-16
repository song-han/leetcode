/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:

// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        solution1(nums);
    }

    private void solution1(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[p++] = nums[i];
        }
        while (p < nums.length) {
            nums[p++] = 0;
        }
    }
}
// @lc code=end

