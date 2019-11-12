/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        StringBuilder word = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (word.length() > 0) {
                    word.append(' ');
                    sb.append(word);
                    word = new StringBuilder();
                }
            } else {
                word.insert(0, c);
                if (i == 0) {
                    word.append(' ');
                    sb.append(word);
                }
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
// @lc code=end

