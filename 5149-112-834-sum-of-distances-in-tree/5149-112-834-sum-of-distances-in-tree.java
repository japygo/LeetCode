class Solution {
    ArrayList<Integer>[] graph;
    int[] count;
    int[] answer;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        answer = new int[n];
        count = new int[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            count[i] = 1;
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        recur(0, -1);
        recur2(0, -1);
        
        return answer;
    }
    
    private void recur(int node, int parent) {
        for (int child : graph[node]) {
            if (child == parent) {
                continue;
            }
            recur(child, node);
            count[node] += count[child];
            answer[node] += answer[child] + count[child];
        }
    }
    
    private void recur2(int node, int parent) {
        for (int child : graph[node]) {
            if (child == parent) {
                continue;
            }
            answer[child] = answer[node] - count[child] + graph.length - count[child];
            recur2(child, node);
        }
    }
}