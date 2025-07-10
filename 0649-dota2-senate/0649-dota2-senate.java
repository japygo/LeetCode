class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        Queue<Character> rQueue = new LinkedList<>();
        Queue<Character> dQueue = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            queue.add(c);
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == 'R') {
                if (dQueue.isEmpty()) {
                    rQueue.add(c);
                } else {
                    queue.add(dQueue.poll());
                }
            } else {
                if (rQueue.isEmpty()) {
                    dQueue.add(c);
                } else {
                    queue.add(rQueue.poll());
                }
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}