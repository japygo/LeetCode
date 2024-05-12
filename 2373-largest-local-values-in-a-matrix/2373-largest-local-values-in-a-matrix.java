class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = max(grid, i, j);
            }
        }

        return maxLocal;
    }
    
    private int max(int[][] grid, int i, int j) {
        int result = 0;

        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                result = Math.max(result, grid[k][l]);
            }
        }

        return result;
    }
}