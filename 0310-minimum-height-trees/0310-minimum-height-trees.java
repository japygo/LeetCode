class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        int[] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            degree[a] += 1;
            degree[b] += 1;
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int num : map.get(poll)) {
                    degree[num] -= 1;
                    if (degree[num] == 1) {
                        queue.add(num);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}