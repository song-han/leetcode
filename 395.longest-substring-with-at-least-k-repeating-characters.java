/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 1; i < 26; i++) {
            max = Math.max(max, longestSubstring(s, k, i));
        }
        return max;
    }

    private int longestSubstring(String s, int k, int unique) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        int notLessThanK = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while (map.size() > unique) {
                    char startC = s.charAt(start);
                    if (map.get(startC) == k) {
                        notLessThanK--;
                    }
                    map.put(startC, map.get(startC) - 1);
                    if (map.get(startC) == 0) {
                        map.remove(startC);
                    }
                    start++;
                }
            }
            if (map.get(c) == k) {
                notLessThanK++;
            }
            if (map.size() == unique && notLessThanK == unique) {
                max = Math.max(max, end - start + 1);
            }
            end++;
        }
        return max;
    }
}
// @lc code=end

