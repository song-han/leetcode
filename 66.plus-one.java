/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

class Solution {
    public int[] plusOne(int[] digits) {
        int remainder = 0;
        int endIdx = digits.length - 1;
        for (int i = endIdx; i >= 0; i--) {
            int value = 0;
            if (i == endIdx) {
                value = digits[i] + 1;
            } else {
                value = digits[i] + remainder;
            }
            remainder = value / 10;
            digits[i] = value % 10;
        }
        if (remainder > 0) {
            int[] results = new int[digits.length + 1];
            results[0] = remainder;
            for (int i = 1; i < results.length; i++) {
                results[i] = digits[i - 1];
            }
            return results;
        }
        return digits;
    }
}
// @lc code=end

