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
    public int goodNodes(TreeNode root) {
        return recur(root, Integer.MIN_VALUE);
    }
    private int recur(TreeNode node, int max) {
        int count = 0;
        if (node.val >= max) {
            count++;
            max = node.val;
        }
        if (node.left != null) {
            count += recur(node.left, max);
        }
        if (node.right != null) {
            count += recur(node.right, max);
        }
        return count;
    }
}