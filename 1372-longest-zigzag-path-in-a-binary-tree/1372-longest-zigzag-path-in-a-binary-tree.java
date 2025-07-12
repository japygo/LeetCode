/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, 0, true), dfs(root.right, 0, false));
    }
    private int dfs(TreeNode node, int count, boolean isLeft) {
        if (node == null) {
            return count;
        }
        if (isLeft) {
            count = Math.max(dfs(node.left, 0, true), dfs(node.right, count + 1, false));
        } else {
            count = Math.max(dfs(node.left, count + 1, true), dfs(node.right, 0, false));
        }
        return count;
    }
}