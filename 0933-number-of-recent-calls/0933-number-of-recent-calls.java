class RecentCounter {
    private final List<Integer> requests;

    public RecentCounter() {
        requests = new ArrayList<>();
    }
    
    public int ping(int t) {
        requests.add(t);
            return Math.toIntExact(requests.stream()
                                           .filter(r -> t - 3000 <= r && r <= t)
                                           .count());
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */