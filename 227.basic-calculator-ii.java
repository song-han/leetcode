/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if ( c == '/' || c == '*' || c == '+' || c == '-') {
                nums.push(Integer.parseInt(numStr.toString()));
                ops.push(c);
                numStr = new StringBuilder();
            } else {
                numStr.append(c);
            }
        }
    }
}
// @lc code=end

