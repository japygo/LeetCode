class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 10001);
            dp[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dp[from][to] = weight;
            dp[to][from] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k][e]);
                }
            }
        }

        int[] neighbours = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && dp[i][j] <= distanceThreshold) {
                    neighbours[i]++;
                }
            }
        }

        int result = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (neighbours[i] <= min) {
                min = neighbours[i];
                result = i;
            }
        }

        return result;
    }
}