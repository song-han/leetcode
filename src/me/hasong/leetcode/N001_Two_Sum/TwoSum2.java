package me.hasong.leetcode.N001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
