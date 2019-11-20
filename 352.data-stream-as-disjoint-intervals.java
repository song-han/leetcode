/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */

// @lc code=start
class SummaryRanges {
    TreeMap<Integer, int[]> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Map.Entry<Integer, int[]> floor = map.floorEntry(val);
        Map.Entry<Integer, int[]> ceil = map.ceilingEntry(val);
        if (
            floor != null && ceil != null &&
            floor.getValue()[1] + 1 == val && ceil.getValue()[0] - 1 == val
        ) {
            int[] floorInterval = floor.getValue();
            int[] ceilInterval = ceil.getValue();
            floorInterval[1] = ceilInterval[1];
            map.remove(ceilInterval[0]);
        } else if (floor != null && floor.getValue()[1] + 1 >= val) {
            int[] interval = floor.getValue();
            interval[1] = Math.max(val, interval[1]);
        } else if (ceil != null && ceil.getValue()[0] - 1 == val) {
            int[] interval = ceil.getValue();
            map.remove(interval[0]);
            map.put(val, new int[]{val, interval[1]});
        } else {
            map.put(val, new int[]{val, val});
        }
    }
    
    public int[][] getIntervals() {
        return map.values().toArray(new int[map.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

