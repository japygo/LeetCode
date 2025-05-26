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
    public List<Integer> rightSideView(TreeNode root) {
        Integer[] result = new Integer[101];
        if (root == null) {
            return List.of();
        }

        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0});

        while (!queue.isEmpty()) {
            Object[] poll = queue.poll();
            TreeNode node = (TreeNode) poll[0];
            int depth = (int) poll[1];

            result[depth] = node.val;

            if (node.left != null) {
                queue.add(new Object[]{node.left, depth + 1});
            }
            if (node.right != null) {
                queue.add(new Object[]{node.right, depth + 1});
            }
        }

        return Arrays.stream(result)
                     .filter(Objects::nonNull)
                     .toList();
    }
}