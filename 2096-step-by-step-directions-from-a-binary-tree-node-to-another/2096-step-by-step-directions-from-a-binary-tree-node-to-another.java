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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        find(root, startValue, startPath);
        find(root, destValue, destPath);

        int index = 0;
        int max = Math.min(startPath.length(), destPath.length());
        while (index < max && startPath.charAt(startPath.length() - index - 1) == destPath.charAt(destPath.length() - index - 1)) {
            index += 1;
        }

        return "U".repeat(startPath.length() - index) + destPath.reverse().substring(index);
    }
    
    private boolean find(TreeNode n, int val, StringBuilder path) {
        if (n.val == val) {
            return true;
        }

        if (n.left != null && find(n.left, val, path)) {
            path.append("L");
        } else if (n.right != null && find(n.right, val, path)) {
            path.append("R");
        }

        return !path.isEmpty();
    }
}