// Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

// Example:

// Input: [1,2,3,4,5]
//           1
//          / \
//         2   3
//        / \     
//       4   5    

// Output: [[4,5,3],[2],[1]]


// Explanation:

// 1. Removing the leaves [4,5,3] would result in this tree:

//           1
//          / 
//         2          

 

// 2. Now removing the leaf [2] would result in this tree:
//           1          

// 3. Now removing the leaf [1] would result in the empty tree:
//           []         

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int h = Math.max(dfs(root.left, result), dfs(root.right, result)) + 1;
        if (result.size() < h) {
            result.add(new ArrayList<>());
        }
        result.get(h - 1).add(root.val);
        return h;
    }
}