class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> projects = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < profits.length; i++) {
            projects.add(new int[]{profits[i], capital[i]});
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            while (!projects.isEmpty() && projects.peek()[1] <= w) {
                queue.add(projects.poll()[0]);
            }

            if (queue.isEmpty()) {
                break;
            }

            w += queue.poll();
        }

        return w;
    }
}