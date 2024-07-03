class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        int small = 0;
        int large = nums.length - 4;

        while (small < 4) {
            result = Math.min(result, nums[large++] - nums[small++]);
        }

        return result;
    }
}