class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = n;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                result = i;
                break;
            }
        }

        return result;
    }
}