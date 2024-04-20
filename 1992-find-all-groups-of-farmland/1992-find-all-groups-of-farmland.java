class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[] tmp;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        m = land.length;
        n = land[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    tmp = new int[4];
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = i;
                    tmp[3] = j;
                    recur(land, i, j);
                    list.add(tmp);
                }
            }
        }

        return list.toArray(new int[][]{});
    }

    public void recur(int[][] land, int row, int col) {
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n ||
                    visited[nx][ny] || land[nx][ny] != 1) {
                continue;
            }
            tmp[2] = Math.max(tmp[2], nx);
            tmp[3] = Math.max(tmp[3], ny);
            recur(land, nx, ny);
        }
    }
}