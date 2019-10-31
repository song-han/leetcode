/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {
    private static final String NULL = "NULL";
    private static final String DIVIDER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean lastLevel = true;
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                TreeNode cur = queue.remove();
                if (cur == null) {
                    sb.append(NULL);
                } else {
                    sb.append(String.valueOf(cur.val));
                    if (cur.left != null || cur.right != null) {
                        lastLevel = false;
                    }
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                sb.append(DIVIDER);
            }
            if (lastLevel) {
                break;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strNodes = data.split(DIVIDER);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strNodes[0]));
        queue.add(root);
        int idx = 1;
        while (!queue.isEmpty() && idx < strNodes.length) {
            TreeNode parent = queue.remove();
            String left = strNodes[idx];
            if (left.equals(NULL)) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.add(parent.left);
            }
            String right = strNodes[idx + 1];
            if (right.equals(NULL)) {
                parent.right = null;
            } else {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.add(parent.right);
            }
            idx += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

