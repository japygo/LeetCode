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

    public int sumNumbers(TreeNode root) {
        result = 0;
        
        recur(root, "");
        
        return result;
    }
    
    private void recur(TreeNode node, String value) {
        value += node.val;

        if (node.left == null && node.right == null) {
            result += Integer.parseInt(value);
            return;
        }

        if (node.left != null) {
            recur(node.left, value);
        }

        if (node.right != null) {
            recur(node.right, value);
        }
    }
}