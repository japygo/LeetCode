class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    recur(grid, i, j);
                    count += 1;
                }
            }
        }

        return count;
    }
    
    private void recur(char[][] grid, int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n ||
                    visited[nx][ny] || grid[nx][ny] == '0') {
                continue;
            }
            recur(grid, nx, ny);
        }
    }
}