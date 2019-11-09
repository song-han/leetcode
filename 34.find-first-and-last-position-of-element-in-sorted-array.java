/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int front = nums.length == 0 ? -1 : findPos(nums, target, true);
        int end = nums.length == 0 ? -1 : findPos(nums, target, false);
        int[] results = new int[2];
        results[0] = front;
        results[1] = end;
        return results;
    }

    private int findPos(int[] nums, int target, boolean front) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j - 1) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                if (front) {
                    j = mid;
                } else {
                    i = mid;
                }
            } else if (nums[mid] < target) {
                i = mid;
            } else {
                j = mid;
            }
        }
        if (front) {
            if (nums[i] == target) {
                return i;
            } else if (nums[j] == target) {
                return j;
            } else {
                return -1;
            }
        } else {
            if (nums[j] == target) {
                return j;
            } else if (nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        }
    }
}
// @lc code=end

