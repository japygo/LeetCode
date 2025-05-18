class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        Arrays.fill(sum, 0);
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int max = sum[k] - sum[0];
        for (int i = 0; i < nums.length - k + 1; i++) {
            max = Math.max(max, sum[i + k] - sum[i]);
        }
        return (double) max / k;
    }
}