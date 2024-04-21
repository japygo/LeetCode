class Solution {
    boolean result;
    boolean[] visited;
    ArrayList<Integer>[] arr;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        result = false;
        visited = new boolean[n];
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            arr[u].add(v);
            arr[v].add(u);
        }

        recur(source, destination);

        return result;
    }
    
    private void recur(int source, int destination) {
        if (source == destination) {
            result = true;
            return;
        }

        visited[source] = true;

        for (Integer s : arr[source]) {
            if (visited[s]) {
                continue;
            }
            recur(s, destination);
        }
    }
}