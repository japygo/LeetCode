class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int count = 0;

        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[j] == max) {
                count += 1;
            }
            while (count == k) {
                if (nums[i] == max) {
                    count -= 1;
                }
                i += 1;
            }
            j += 1;
            result += i;
        }

        return result;
    }
}