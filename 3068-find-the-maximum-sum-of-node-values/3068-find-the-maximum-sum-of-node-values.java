class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long result = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            result += num;
            int xor = num ^ k;
            int diff = xor - num;

            if (diff > 0) {
                min = Math.min(min, diff);
                count += 1;
                result += diff;
            } else {
                max = Math.max(max, diff);
            }
        }

        if (count % 2 == 0) {
            return result;
        }

        return Math.max(result - min, result + max);
    }
}