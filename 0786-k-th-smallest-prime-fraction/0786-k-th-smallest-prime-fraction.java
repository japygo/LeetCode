class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> (double) arr[o[0]] / arr[o[1]]));
        for (int i = 0; i < arr.length; i++) {
            queue.add(new int[]{i, arr.length - 1});
        }

        while (k > 1) {
            int[] poll = queue.poll();
            if (poll[0] < poll[1] - 1) {
                queue.add(new int[]{poll[0], poll[1] - 1});
            }
            k -= 1;
        }

        int[] result = queue.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}