class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double result = Double.MAX_VALUE;
        int n = quality.length;
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new Worker(quality[i], wage[i]));
        }
        workers.sort(Comparator.comparingDouble(o -> o.wage / o.quality));

        PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (Worker worker : workers) {
            queue.add(worker.quality);
            sum += worker.quality;
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            if (queue.size() == k) {
                result = Math.min(result, sum * worker.wage / worker.quality);
            }
        }

        return result;
    }
    
    class Worker {
        private final double quality;
        private final int wage;

        public Worker(double quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }
    }
}