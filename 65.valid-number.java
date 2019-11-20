/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        return validNum(s.trim());
    }
    
    private boolean validNum(String s) {
        boolean dot = false;
        boolean num = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-' || c == '+') {
                if (i > 0) {
                    return false;
                }
            } else if (c == 'e') {
                return num && validExp(s.substring(i + 1));
            } else if (c == '.') {
                if (dot) return false;
                dot = true;
            } else if (c >= '0' && c <= '9') {
                num = true;
            } else {
                return false;
            }
        }
        return num;
    }
    
    private boolean validExp(String s) {
        if (s.length() == 0) {
            return false;
        }
        boolean num = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (i > 0) return false;
            } else if (c >= '0' && c <= '9') {
                num = true;
            } else {
                return false;
            }
        }
        return num;
    }
}
// @lc code=end

