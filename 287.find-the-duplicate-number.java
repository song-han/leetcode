/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int curIdx = 0;
        while (nums[curIdx] != nums[nums[curIdx]]) {
            int targetIdx = nums[curIdx];
            int temp = nums[curIdx];
            nums[curIdx] = nums[targetIdx];
            nums[targetIdx] = temp;
        }
        return nums[curIdx];
    }
}
// @lc code=end

