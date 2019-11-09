/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if(!compare(words[i - 1], words[i], orderMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String w1, String w2, int[] orderMap) {
        int m = w1.length();
        int n = w2.length();
        for (int i = 0; i < m && i < n; i++) {
            int order1 = orderMap[w1.charAt(i) - 'a'];
            int order2 = orderMap[w2.charAt(i) - 'a'];
            if (order1 != order2) {
                return order1 < order2;
            }
        }
        return m <= n;
    }
}
// @lc code=end

