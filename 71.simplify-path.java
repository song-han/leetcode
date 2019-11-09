/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        Set<String> specialPaths = new HashSet<>();
        specialPaths.add("..");
        specialPaths.add(".");
        specialPaths.add("");
        for (String subPath: paths) {
            if (subPath.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!specialPaths.contains(subPath)) {
                stack.push(subPath);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String subPath: stack) {
            sb.append('/');
            sb.append(subPath);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
// @lc code=end

