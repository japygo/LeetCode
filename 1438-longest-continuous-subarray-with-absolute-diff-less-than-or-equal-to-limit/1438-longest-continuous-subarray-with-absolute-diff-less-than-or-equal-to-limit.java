class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int result = 0;
        int start = 0;
        int end = 0;
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();

        while (end < nums.length) {
            while (!min.isEmpty() && nums[end] < min.peekLast()) {
                min.pollLast();
            }
            min.addLast(nums[end]);

            while (!max.isEmpty() && nums[end] > max.peekLast()) {
                max.pollLast();
            }
            max.addLast(nums[end]);

            while (max.peekFirst() - min.peekFirst() > limit) {
                if (nums[start] == min.peekFirst()) {
                    min.pollFirst();
                }
                if (nums[start] == max.peekFirst()) {
                    max.pollFirst();
                }
                start += 1;
            }

            result = Math.max(result, end - start + 1);
            end += 1;
        }

        return result;
    }
}