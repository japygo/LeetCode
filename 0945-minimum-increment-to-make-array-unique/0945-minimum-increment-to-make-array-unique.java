class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result = 0;

        Arrays.sort(nums);

        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= num) {
                num = num + 1;
                result += num - nums[i];
            } else {
                num = nums[i];
            }
        }

        return result;
    }
}