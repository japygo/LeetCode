class Solution {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int m;
    private int n;
    private boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        int origin = image[sr][sc];
        recur(image, sr, sc, origin, color);
        return image;
    }

    private void recur(int[][] image, int row, int col, int origin, int color) {
        if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != origin || visited[row][col]) {
            return;
        }
        image[row][col] = color;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            recur(image, row + dx[i], col + dy[i], origin, color);
        }
    }
}