/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    // 如果s[i]是1-9，num += mem[i-1]
    // 如果s[i-1, i]是10-26，num += mem[i-2];
    public int numDecodings(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int pre2 = 1;
        int pre1 = str[0] > '0' && str[0] <= '9' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            int num = 0;
            if (str[i] > '0' && str[i] <= '9') {
                num += pre1;
            }
            String c = s.substring(i - 1, i + 1);
            if (c.compareTo("10") >= 0 && c.compareTo("26") <= 0) {
                num += pre2;
            }
            pre2 = pre1;
            pre1 = num;
        }
        return pre1;
    }
}
// @lc code=end

