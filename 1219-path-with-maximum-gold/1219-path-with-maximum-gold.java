class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    int max = 0;
    
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == 0) {
                    continue;
                }
                visited = new boolean[m][n];
                visited[y][x] = true;
                recur(grid, x, y, 0);
            }
        }

        return max;
    }
    
    private void recur(int[][] grid, int x, int y, int sum) {
        sum += grid[y][x];
        max = Math.max(max, sum);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                    visited[ny][nx] ||
                    grid[ny][nx] == 0) {
                continue;
            }
            visited[ny][nx] = true;
            recur(grid, nx, ny, sum);
            visited[ny][nx] = false;
        }
    }
}