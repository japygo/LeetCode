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
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;

        if (root.left != null && root.left.left == null  && root.left.right == null) {
            result += root.left.val;
        }

        if (root.left != null) {
            result += sumOfLeftLeaves(root.left);
        }

        if (root.right != null) {
            result += sumOfLeftLeaves(root.right);
        }

        return result;
    }
}