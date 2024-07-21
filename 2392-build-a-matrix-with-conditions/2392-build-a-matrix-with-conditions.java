class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rows = topologicalSort(k, rowConditions);
        List<Integer> cols = topologicalSort(k, colConditions);
        if (rows.isEmpty() || cols.isEmpty()) {
            return new int[0][];
        }

        int[][] result = new int[k][k];

        for (int i = 0; i < k; i++) {
            int row = rows.get(i);
            for (int j = 0; j < k; j++) {
                int col = cols.get(j);
                if (row == col) {
                    result[i][j] = row;
                }
            }
        }

        return result;
    }
    
    private List<Integer> topologicalSort(int k, int[][] matrix) {
        ArrayList<Integer>[] graph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[k + 1];

        for (int[] arr : matrix) {
            graph[arr[0]].add(arr[1]);
            indegree[arr[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (int next : graph[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (result.size() != k) {
            return new ArrayList<>();
        }

        return result;
    }
}