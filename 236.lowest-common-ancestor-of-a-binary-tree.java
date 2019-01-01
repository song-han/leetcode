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
        System.out.println("---");
        LinkedList<TreeNode> queue2 = findPath(root, q);
        TreeNode parent = root;
        queue1.removeFirst();
        queue2.removeFirst();
        System.out.println(queue1.size()+ "," + queue2.size());
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode cur1 = queue1.removeFirst();
            TreeNode cur2 = queue2.removeFirst();
            System.out.println(cur1.val + "," + cur2.val);
            if (cur1 != cur2) {
                return parent;
            }
            parent = cur1;
        }
        return null;
    }

    private LinkedList<TreeNode> findPath(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        while (root != null) {
            queue.addLast(root);
            root = root.left;
        }
        while (!queue.isEmpty()) {
            TreeNode t = queue.getLast();
            if (t == p) {
                break;
            }
            t = queue.removeLast();
            t = t.right;
            while (t != null) {
                queue.addLast(t);
                t = t.left;
            }
        }
        while(!queue.isEmpty()) {
            System.out.print(queue.removeFirst().val);
        }
        System.out.print("---");
        return queue;
    }
}
// @lc code=end

