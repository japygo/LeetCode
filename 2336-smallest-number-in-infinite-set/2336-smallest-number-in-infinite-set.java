class SmallestInfiniteSet {
    private final PriorityQueue<Integer> queue;
    private int value;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        value = 1;
    }
    
    public int popSmallest() {
        if (queue.isEmpty() || queue.peek() > value) {
            return value++;
        }
        return queue.poll();
    }
    
    public void addBack(int num) {
        if (num < value && !queue.contains(num)) {
            queue.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */