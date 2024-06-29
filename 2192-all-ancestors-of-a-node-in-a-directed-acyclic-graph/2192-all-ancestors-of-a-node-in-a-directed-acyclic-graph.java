class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] arr = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            arr[edge[1]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph.get(from)) {
                arr[to] -= 1;
                ancestors.get(to).add(from);
                for (int ancestor : ancestors.get(from)) {
                    ancestors.get(to).add(ancestor);
                }
                if (arr[to] == 0) {
                    queue.add(to);
                }

            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(ancestors.get(i).stream().sorted().toList());
        }

        return result;
    }
}