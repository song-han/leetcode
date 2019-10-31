/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet(wordDict);
        boolean[] canBreak = new boolean[s.length()];
        for (int i = 0; i < canBreak.length; i++) {
            canBreak[i] = false;
        }
        // canBreak[i]
        // canBreak[0 ~ j]
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (words.contains(str)) {
                canBreak[i] = true;
                continue;
            } else {
                canBreak[i] = false;
            }
            for (int j = 0; j < i; j++) {
                if (canBreak[j] == true) {
                    str = s.substring(j + 1, i + 1);
                    if (words.contains(str)) {
                        canBreak[i] = true;
                    }
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }
}
// @lc code=end

