class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(0, tickets.length).forEach(queue::add);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            tickets[index] -= 1;
            if (tickets[index] > 0) {
                queue.add(index);
            }
            result += 1;
            if (tickets[k] == 0) {
                break;
            }
        }

        return result;
    }
}