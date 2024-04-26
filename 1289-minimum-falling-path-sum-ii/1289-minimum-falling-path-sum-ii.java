class Solution {
    int[][] dp;

    public int minFallingPathSum(int[][] grid) {
        int result = Integer.MAX_VALUE;
        dp = new int[grid.length][grid.length];

        for (int i = 0; i < grid.length; i++) {
            result = Math.min(result, recur(grid, 0, i));
        }

        return result;
    }
    
    private int recur(int[][] grid, int row, int col) {
        if (row == grid.length - 1) {
            return grid[row][col];
        }
        
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if (i == col) {
                continue;
            }
            sum = Math.min(sum, recur(grid, row + 1, i));
        }

        dp[row][col] = grid[row][col] + sum;
        
        return dp[row][col];
    }
}