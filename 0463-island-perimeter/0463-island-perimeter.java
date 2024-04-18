class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                result += 4;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] == 0) {
                        continue;
                    }

                    result -= 1;
                }
            }
        }

        return result;
    }
}