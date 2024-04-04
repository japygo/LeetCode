class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth += 1;
            } else if (c == ')') {
                result = Math.max(result, depth);
                depth -= 1;
            }
        }

        return result;
    }
}