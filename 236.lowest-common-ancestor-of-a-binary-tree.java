/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue1 = findPath(root, p);
        LinkedList<TreeNode> queue2 = findPath(root, q);
        TreeNode parent = root;
        queue1.removeFirst();
        queue2.removeFirst();
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode cur1 = queue1.removeFirst();
            TreeNode cur2 = queue2.removeFirst();
            if (cur1 != cur2) {
                return parent;
            }
            parent = cur1;
        }
        return parent;
    }

    private LinkedList<TreeNode> findPath(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> nodeVisitedState = new HashMap<TreeNode, Integer>();
        int NONE = 0;
        int LEFT = 1;
        int BOTH = 2;
        queue.addLast(root);
        nodeVisitedState.put(root, NONE);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.getLast();
            if (cur == p) {
                return queue;
            }
            int state = nodeVisitedState.get(cur);
            if (state == NONE) {
                if (cur.left != null) {
                    queue.addLast(cur.left);
                    nodeVisitedState.put(cur.left, NONE);
                }
                nodeVisitedState.put(cur, LEFT);
            } else if (state == LEFT) {
                if (cur.right != null) {
                    queue.addLast(cur.right);
                    nodeVisitedState.put(cur.right, NONE);
                }
                nodeVisitedState.put(cur, BOTH);
            } else {
                queue.removeLast();
            }
        }
        return null;
    }
}
// @lc code=end

