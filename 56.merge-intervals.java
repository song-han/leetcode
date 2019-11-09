/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        int[] last = intervals[0];
        for (int[] interval: intervals) {
            if (last[1] >= interval[0]) {
                last[1] = Math.max(last[1], interval[1]);
            } else {
                list.add(interval);
                last = interval;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
// @lc code=end

