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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        dfs(root, map, result);
        return result;
    }
    private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) {
            return "";
        }
        String left = dfs(node.left, map, result);
        String right = dfs(node.right, map, result);
        String key = node.val + "/" + left + "/" + right;
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            result.add(node);
        }
        return key;
    }
}