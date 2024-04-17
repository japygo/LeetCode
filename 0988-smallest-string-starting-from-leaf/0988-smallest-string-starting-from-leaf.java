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
    String result;

    public String smallestFromLeaf(TreeNode root) {
        result = "";

        recur(root, "");

        return result;
    }
    
    public void recur(TreeNode node, String value) {
        value = (char) (node.val + 'a') + value;

        if (node.left == null && node.right == null) {
            result = result.isEmpty() || result.compareTo(value) > 0 ? value : result;
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