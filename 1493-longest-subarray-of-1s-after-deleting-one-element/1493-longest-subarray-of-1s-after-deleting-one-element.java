class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int zero = 0;
        int max = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[start] == 0) {
                    zero--;
                }
                start++;
            }
            max = Math.max(max, end - start);
            end++;
        }
        return max;
    }
}