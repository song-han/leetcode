/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null || s.length() == 0) 
    //         return 0;
    //     Set<Character> set = new HashSet<>();
    //     int start = 0;
    //     int end = 0;
    //     int max = 0;
    //     while (end < s.length()) {
    //         if (set.contains(s.charAt(end))) {
    //             set.remove(s.charAt(start++));
    //         } else {
    //             set.add(s.charAt(end++));
    //             max = Math.max(max, end - start);
    //         }
    //     }
    //     return max;
    // }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end++);
            max = Math.max(max, end - start);
        }
        return max;
    }
}

