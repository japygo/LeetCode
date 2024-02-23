class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Node>[] nodes = new ArrayList[n];
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            nodes[from].add(new Node(to, price, 0));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.k == o2.k) {
                return o1.price - o2.price;
            }
            return o1.k - o2.k;
        });
        dist[src] = 0;
        queue.add(new Node(src, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.k > k) {
                continue;
            }
            for (Node next : nodes[node.to]) {
                if (node.price + next.price < dist[next.to]) {
                    dist[next.to] = node.price + next.price;
                    queue.add(new Node(next.to, dist[next.to], node.k + 1));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];
    }
    
    static class Node {
        private final int to;
        private final int price;
        private final int k;

        public Node(int to, int price, int k) {
            this.to = to;
            this.price = price;
            this.k = k;
        }
    }
}