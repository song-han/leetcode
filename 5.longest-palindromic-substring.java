/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start

// string | dynamic-programming

class Solution {
    public String longestPalindrome(String s) {
        return solution1(s);
    }

    private String solution1(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = findLongestPalindrome(s, i, i);
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String temp = findLongestPalindrome(s, i, i+ 1);
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }

    private String findLongestPalindrome(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j)) {
            return "";
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i+1, j);
    }
}
// @lc code=end

