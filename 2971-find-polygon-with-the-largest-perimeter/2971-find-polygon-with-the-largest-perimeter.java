class Solution {
    public long largestPerimeter(int[] nums) {
        long result = -1;

        Arrays.sort(nums);

        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < sum[i - 1]) {
                result = sum[i];
                break;
            }
        }

        return result;
    }
}