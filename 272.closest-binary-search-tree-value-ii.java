// Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

// Note:

//     Given target value is a floating point.
//     You may assume k is always valid, that is: k ≤ total nodes.
//     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

// Example:

// Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

//     4
//    / \
//   2   5
//  / \
// 1   3

// Output: [4,3]


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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        boolean P = true;
        boolean S = false;
        Stack<TreeNode> p = new Stack<>(); // nodes less than or equal to target.
        Stack<TreeNode> s = new Stack<>(); // nodes greater than target.
        TreeNode cur = root;
        while (cur != null) {
            if (target > cur.val) {
                p.push(cur);
                cur = cur.right;
            } else {
                s.push(cur);
                cur = cur.left;
            }
        }
        List<Integer> result = new LinkedList<>();
        while (result.size() < k) {
            if (p.isEmpty()) {
                result.add(next(s, S));
            } else if (s.isEmpty()) {
                result.add(next(p, P));
            } else {
                double diffP = target - p.peek().val;
                double diffS =  s.peek().val - target;
                if (diffP <= diffS) {
                    result.add(next(p,P));
                } else {
                    result.add(next(s, S));
                }
            }
        }
        return result;
    }
        
    private int next(Stack<TreeNode> stack, boolean isPrecessor) {
        TreeNode cur = stack.pop();
        int ret = cur.val;
        cur = isPrecessor ? cur.left: cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = isPrecessor? cur.right: cur.left;
        }
        return ret;
    }
}