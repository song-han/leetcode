/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map1.containsKey(c1) && !map2.containsKey(c2)) {
                map1.put(c1, i);
                map2.put(c2, i);
            } else if (map1.containsKey(c1) && map2.containsKey(c2)) {
                if (map1.get(c1) != map2.get(c2)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

