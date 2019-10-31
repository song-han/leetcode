/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start

class Solution {
    public int balancedString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        count.put('Q', 0);
        count.put('W', 0);
        count.put('E', 0);
        count.put('R', 0);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.get(c) + 1);
        }
        int k = n / 4;
        int i = 0;
        int res = n;
        for (int j = 0; j < n; j++) {
            char eChar = s.charAt(j);
            count.put(eChar, count.get(eChar) - 1);
            while (i < n && count.get('Q') <= k && count.get('W') <= k && count.get('E') <= k && count.get('R') <= k) {
                res = Math.min(res, j - i + 1);
                if (res == 0) {
                    return 0;
                }
                char sChar = s.charAt(i);
                count.put(sChar, count.get(sChar) + 1);
                i++;
            }
            
        }
        return res;
    }
}
// @lc code=end

