/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root.val > p.val && root.val > q.val) {
    //         return lowestCommonAncestor(root.left, p, q);
    //     }
    //     else if (root.val < p.val && root.val < q.val) {
    //         return lowestCommonAncestor(root.right, p, q);
    //     } else {
    //         return root;
    //     }
    // }

    // The ancestor should have a value in range [p, q] if p < q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    }
}
// @lc code=end

