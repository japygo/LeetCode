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
    public boolean isEvenOddTree(TreeNode root) {
        boolean result = true;

        Map<Integer, Stack<Integer>> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode treeNode = node.treeNode;
            if (treeNode == null) {
                continue;
            }
            int level = node.level;
            int value = treeNode.val;
            if (!isValid(level, value)) {
                result = false;
                break;
            }

            boolean isLevelEven = level % 2 == 0;
            Stack<Integer> stack = map.getOrDefault(level, new Stack<>());
            if (!stack.isEmpty()) {
                int num = stack.peek();
                if (isLevelEven) {
                    if (num >= value) {
                        result = false;
                        break;
                    }
                } else {
                    if (num <= value) {
                        result = false;
                        break;
                    }
                }
            }
            stack.add(value);
            map.put(level, stack);

            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            queue.add(new Node(left, level + 1));
            queue.add(new Node(right, level + 1));
        }

        return result;
    }
    
    private boolean isValid(int a, int b) {
        return a % 2 != b % 2;
    }
    
    static class Node {
        private TreeNode treeNode;
        private int level;

        public Node(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}