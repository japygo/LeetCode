class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    arr[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int row = tmp[0];
            int col = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n ||
                        arr[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                arr[nr][nc] = arr[row][col] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> arr[o2[0]][o2[1]] - arr[o1[0]][o1[1]]);
        priorityQueue.add(new int[]{0, 0});

        while (!priorityQueue.isEmpty()) {
            int[] tmp = priorityQueue.poll();
            int row = tmp[0];
            int col = tmp[1];

            if (row == n - 1 && col == n - 1) {
                return arr[row][col];
            }
            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n ||
                        visited[nr][nc]) {
                    continue;
                }
                arr[nr][nc] = Math.min(arr[row][col], arr[nr][nc]);
                priorityQueue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        
        return 0;
    }
}