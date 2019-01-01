/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1:

// Input: [3,0,1]
// Output: 2
// Example 2:

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8
// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

class Solution {

    public int missingNumber(int[] nums) {
        return solution1(nums);
    }

    public int solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != -1) {
                if (nums[i] == nums.length) {
                    nums[i] = -1;
                } else {
                    int targetIdx = nums[i];
                    int temp = nums[targetIdx];
                    nums[targetIdx] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                return i;
            }
        }
        return nums.length;
    }
}
// @lc code=end

