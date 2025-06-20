class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] arr = new int[nums.length + 1];
        arr[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (start <= end && end <= nums.length) {
            int sum = arr[end] - arr[start];
            if (sum < target) {
                end++;
            } else {
                result = Math.min(result, end - start);
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}