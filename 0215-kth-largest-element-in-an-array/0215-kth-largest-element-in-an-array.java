class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.add(num);
        }
        int result = 0;
        while (k-- > 0) {
            result = queue.poll();
        }
        return result;
    }
}