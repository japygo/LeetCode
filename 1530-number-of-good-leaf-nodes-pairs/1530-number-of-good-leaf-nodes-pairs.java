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
    public int countPairs(TreeNode root, int distance) {
        int result = 0;
        List<TreeNode> leaves = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();

        findLeaves(root, leaves, new ArrayList<>(), map);

        for (int i = 0; i < leaves.size(); i++) {
            for (int j = i + 1; j < leaves.size(); j++) {
                List<TreeNode> iList = map.get(leaves.get(i));
                List<TreeNode> jList = map.get(leaves.get(j));
                for (int k = 0; k < Math.min(iList.size(), jList.size()); k++) {
                    if (iList.get(k) != jList.get(k)) {
                        int dist = iList.size() - k + jList.size() - k;
                        if (dist <= distance) {
                            result += 1;
                        }
                        break;
                    }
                }
            }
        }

        return result;
    }
    
    private void findLeaves(TreeNode node, List<TreeNode> leaves, List<TreeNode> list, Map<TreeNode, List<TreeNode>> map) {
        if (node == null) {
            return;
        }

        List<TreeNode> tmp = new ArrayList<>(list);
        tmp.add(node);

        if (node.left == null && node.right == null) {
            map.put(node, tmp);
            leaves.add(node);
            return;
        }

        findLeaves(node.left, leaves, tmp, map);
        findLeaves(node.right, leaves, tmp, map);
    }
}