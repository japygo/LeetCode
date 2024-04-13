class Solution {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        int[] heights = new int[matrix[0].length + 1];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == '1' ? heights[i] + 1 : 0;
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    result = Math.max(result, h * w);
                }
                stack.push(i);
            }
        }

        return result;
    }
}