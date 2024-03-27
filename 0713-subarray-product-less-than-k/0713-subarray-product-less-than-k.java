class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int sum = 1;
        int start = 0;
        int end = 0;

        while (start < nums.length && end < nums.length) {
            sum *= nums[end];
            while (sum >= k) {
                sum /= nums[start];
                start += 1;
            }
            count += end - start + 1;
            end += 1;
        }

        return count;
    }
}