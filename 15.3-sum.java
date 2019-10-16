/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
    }

    private List<List<Integer>> solution1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i -1 ]) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[start]);
                        triple.add(nums[end]);
                        result.add(triple);
                    }
                }
            }
        }
    }
}
// @lc code=end

