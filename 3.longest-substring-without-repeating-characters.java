/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) 
//             return 0;
//         Set<Character> set = new HashSet<>();
//         int start = 0;
//         int end = 0;
//         int max = 0;
//         while(end < s.length()) {
//             char c = s.charAt(end);
//             if (set.contains(c)) {
//                 while(set.contains(c)) {
//                     set.remove(s.charAt(start));
//                     start ++;
//                 }
//             } else {
//                 set.add(c);
//                 max = Math.max(max, end - start + 1);
//                 end ++;
//             }
//         }
//         return max;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
                end++;
            }
        }
        return max;
    }
}

