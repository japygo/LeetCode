class Solution {
    record Pair(int nums1, int nums2) {}
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;
        Pair[] pairs = new Pair[length];
        for (int i = 0; i < length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, (o1, o2) -> o2.nums2 - o1.nums2);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (Pair pair : pairs) {
            sum += pair.nums1;
            queue.offer(pair.nums1);
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            if (queue.size() == k) {
                max = Math.max(max, sum * pair.nums2);
            }
        }
        return max;
    }
}