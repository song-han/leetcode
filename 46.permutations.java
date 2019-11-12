/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums, set, permutation, permutations);
        return permutations;
    }

    private void dfs(int[] nums, Set<Integer> set, List<Integer> permutation, List<List<Integer>> permutations) {
        if (set.size() == nums.length) {
            permutations.add(new ArrayList<Integer>(permutation));
        }
        for (int num: nums) {
            if (set.contains(num)) continue;
            set.add(num);
            permutation.add(num);
            dfs(nums, set, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            set.remove(num);
        }
    }
}
// @lc code=end

