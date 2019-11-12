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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // return solution1(root);
        return solution2(root);
    }
    
    /**
     * iterative
     */
    public TreeNode solution2(TreeNode root) {
        TreeNode node = root;
        TreeNode parent = null;
        TreeNode right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
    }
    
    /**
     * recursive
     */
    public TreeNode solution1(TreeNode root) {
        if (root == null) return null;
        return flip(root);
    }
    
    private TreeNode flip(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = flip(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.right = null;
        root.left = null;
        return newRoot;
    }
    
    
}