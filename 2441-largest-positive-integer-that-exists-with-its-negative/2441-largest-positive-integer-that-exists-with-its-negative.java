class Solution {
    public int findMaxK(int[] nums) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while (left < right) {
            int start = nums[left];
            int end = nums[right];
            if (-start == end) {
                result = end;
                break;
            } else if (-start < end) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return result;
    }
}