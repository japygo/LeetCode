class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (Integer value : map.values()) {
            queue.offer(value);
        }

        while (!queue.isEmpty()) {
            result += (long) queue.poll() * n--;
        }

        return result;
    }
}