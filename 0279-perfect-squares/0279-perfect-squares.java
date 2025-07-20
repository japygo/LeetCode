class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                int sqrt = (int) Math.sqrt(poll);
                while (sqrt > 0) {
                    int num = poll - sqrt * sqrt;
                    if (num == 0) {
                        return step;
                    }
                    if (num > 0) {
                        queue.add(num);
                    }
                    sqrt--;
                }
            }
        }
        return step;
    }
}