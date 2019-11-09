/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 找到最后一行，最右边node的index。
     * 2^(d - 1)

     */
    public int countNodes(TreeNode root) {
        int d = getDepth(root);
        if (d == 0 ) return d;
        int end = (int)Math.pow(2, d - 1) - 1;
        int left = 0;
        int right = end;
        while (left < right - 1) {
            int idx = left + (right - left) / 2;
            boolean isExisted = exists(root, idx, end);
            if (isExisted) {
                left = idx;
            } else {
                right = idx;
            }
        }
        if (exists(root, right, end)) {
            return (int)Math.pow(2, d - 1) + right;
        }
        
        return (int)Math.pow(2, d - 1) + left;
        
        
    }

    private int getDepth(TreeNode root) {
        int d = 0;
        while (root != null) {
            d++;
            root = root.left;
        }
        return d;
    }
    /**
          1
      2       3
    4   5   6
     */

    private boolean exists(TreeNode node, int idx, int end) {
        int start = 0;
        while (start < end) {
            int pivot = (end - start) / 2 + start;
            if (pivot >= idx) {
                node = node.left;
                end = pivot;
            } else {
                node = node.right;
                start = pivot + 1;
            }
        }
        return node != null;
    }
}
// @lc code=end

