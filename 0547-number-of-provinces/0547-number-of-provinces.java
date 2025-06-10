class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            count += recur(isConnected, i, visited);
        }
        return count;
    }
    private int recur(int[][] isConnected, int index, boolean[] visited) {
        if (visited[index]) {
            return 0;
        }
        visited[index] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[index][i] == 1 && !visited[i]) {
                recur(isConnected, i, visited);
            }
        }
        return 1;
    }
}