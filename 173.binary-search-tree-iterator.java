/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

    TreeNode head;

    public BSTIterator(TreeNode root) {
        head = new TreeNode(0);
        init(root);
    }

    private void init(TreeNode root) {
        // inorder traverse
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode tail = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()) {
            cur = stack.pop();
            tail.right = cur;
            tail = tail.right;
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode next = head.right;
        head = head.right;
        return next.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return head.right != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

