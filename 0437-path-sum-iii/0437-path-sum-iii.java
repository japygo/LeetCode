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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return recur(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    private int recur(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        sum += root.val;
        if (targetSum == sum) {
            count++;
        }
        count += recur(root.left, targetSum, sum);
        count += recur(root.right, targetSum, sum);
        return count;
    }
}