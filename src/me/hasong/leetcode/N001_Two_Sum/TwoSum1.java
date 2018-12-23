package me.hasong.leetcode.N001_Two_Sum;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2]; // TODO: How many ways to initialize an array in Java.

        // Have two loops and check each possible pairs and find the first valid pair.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // j = i+1 is because we can't use same element twice.
                if (target == nums[i] + nums[j]) {
                    // NOTE: return indices not value
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution"); // NOTE: runtime exception
    }

}
