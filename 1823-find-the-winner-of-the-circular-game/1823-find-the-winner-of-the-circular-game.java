class Solution {
    public int findTheWinner(int n, int k) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            result = queue.poll();
        }

        return result;
    }
}