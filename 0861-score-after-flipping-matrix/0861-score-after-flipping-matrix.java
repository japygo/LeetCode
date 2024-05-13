class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    count += 1;
                }
            }

            if (count > m - count) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                tmp.append(grid[i][j]);
            }
            result += Integer.parseInt(tmp.toString(), 2);
        }
        return result;
    }
}