class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int start = 0;
        int end = 0;
        int count = 0;

        while (end < nums.length) {
            if (nums[end] % 2 == 1) {
                k -= 1;
                count = 0;
            }

            while (k == 0) {
                if (nums[start] % 2 == 1) {
                    k += 1;
                }
                start += 1;
                count += 1;
            }

            result += count;
            end += 1;
        }

        return result;
    }
}