/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, result, subset);
        return result;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> result, List<Integer> subset) {
        if (idx == nums.length - 1) {
            result.add(new ArrayList(subset));
            subset.add(nums[idx]);
            result.add(new ArrayList(subset));
            subset.remove(subset.size() - 1);
        } else {
            dfs(nums, idx + 1, result, subset);
            subset.add(nums[idx]);
            dfs(nums, idx + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    } 
}
// @lc code=end

