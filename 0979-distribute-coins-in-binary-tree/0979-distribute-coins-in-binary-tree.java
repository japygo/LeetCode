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
    int result;
    
    public int distributeCoins(TreeNode root) {
        result = 0;
        recur(root);
        return result;
    }
    
    private int recur(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = recur(node.left);
        int right = recur(node.right);

        result += Math.abs(left) + Math.abs(right);

        return left + right + node.val - 1;
    }
}