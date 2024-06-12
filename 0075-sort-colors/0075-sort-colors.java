class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i >= left && i <= right) {
                int num = nums[i];
                if (num == 0) {
                    int tmp = nums[left];
                    nums[left] = num;
                    nums[i] = tmp;
                    left += 1;
                } else if (num == 2) {
                    int tmp = nums[right];
                    nums[right] = num;
                    nums[i] = tmp;
                    right -= 1;
                } else {
                    break;
                }
            }
        }
    }
}