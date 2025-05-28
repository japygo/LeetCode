class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        visited[entrance[0]][entrance[1]] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            count += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.' && !visited[nx][ny]) {
                        if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                            return count;
                        }
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return -1;
    }
}