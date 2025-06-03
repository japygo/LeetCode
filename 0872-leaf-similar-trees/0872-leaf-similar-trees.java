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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = recur(root1, new ArrayList<>());
        List<Integer> list2 = recur(root2, new ArrayList<>());
        return list1.equals(list2);
    }
    private List<Integer> recur(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        if (root.left != null) {
            list = recur(root.left, list);
        }
        if (root.right != null) {
            list = recur(root.right, list);
        }
        return list;
    }
}