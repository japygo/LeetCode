class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int length = deck.length;
        int[] result = new int[length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);

        for (int d : deck) {
            result[queue.poll()] = d;

            queue.add(queue.poll());
        }

        return result;
    }
}