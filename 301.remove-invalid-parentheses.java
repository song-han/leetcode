/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        bfs(s, 0, new StringBuilder(), set, 0);
        List<String> results = new ArrayList<>();
        int max = 0;
        for (String str: set) {
            if (str.length() == max) {
                results.add(str);
            } else if (str.length() > max) {
                max = str.length();
                results = new ArrayList<>();
                results.add(str);
            }
        }
        return results;
    }

    private void bfs(String s, int idx, StringBuilder sb, Set<String> results, int leftCount) {
        if (idx == s.length()) {
            if (leftCount == 0) {
                results.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            sb.append(c);
            bfs(s, idx + 1, sb, results, leftCount + 1);
            sb.deleteCharAt(sb.length() - 1);
            bfs(s, idx + 1, sb, results, leftCount);
        } else if (c == ')') {
            if (leftCount >= 1) {
                sb.append(c);
                bfs(s, idx + 1, sb, results, leftCount - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            bfs(s, idx + 1, sb, results, leftCount);
        } else {
            sb.append(c);
            bfs(s, idx + 1, sb, results, leftCount);
            sb.deleteCharAt(sb.length() - 1);
        }
    
    } 
}
// @lc code=end

