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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        recur(root, val, depth);
        
        return root;
    }
    
    private void recur(TreeNode node, int val, int depth) {
        if (node == null) {
            return;
        }

        if (depth == 2) {
            TreeNode newLeftNode = new TreeNode(val);
            TreeNode newRightNode = new TreeNode(val);
            newLeftNode.left = node.left;
            newRightNode.right = node.right;
            node.left = newLeftNode;
            node.right = newRightNode;
            return;
        }

        recur(node.left, val, depth - 1);
        recur(node.right, val, depth - 1);
    }
}