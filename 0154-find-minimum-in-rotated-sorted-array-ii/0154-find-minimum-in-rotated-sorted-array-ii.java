class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                result = Math.min(result, nums[mid]);
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                result = Math.min(result, nums[right]);
                left = mid + 1;
            } else {
                result = Math.min(result, nums[right]);
                right--;
            }
        }
        return result;
    }
}