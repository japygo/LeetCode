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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Set<Integer> set = new HashSet<>();
        for (int d : to_delete) {
            set.add(d);
        }

        if (!set.contains(root.val)) {
            result.add(root);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                if (set.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                queue.add(node.right);
                if (set.contains(node.right.val)) {
                    node.right = null;
                }
            }

            if (set.contains(node.val)) {
                if (node.left != null) {
                    result.add(node.left);
                }
                if (node.right != null) {
                    result.add(node.right);
                }
            }
        }

        return result;
    }
}