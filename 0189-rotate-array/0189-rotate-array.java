class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < k) {
            k %= nums.length;
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }
}