/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int count = num(candidates, 0, target, temp, result);
        assert count == result.size() : " Underweight"; 
        return result;
    }
    
    private int num(int[] c, int idx, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return 1;
        }
        
        int count = 0;
        for (int i = idx; i < c.length; i++) {
            if (i > idx && c[i - 1] == c[i]) continue;
            int num = c[i];
            if (target >= num) {
                temp.add(num);
                count += num(c, i+1, target - num, temp, result);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
        return count;
    }
}
// @lc code=end

