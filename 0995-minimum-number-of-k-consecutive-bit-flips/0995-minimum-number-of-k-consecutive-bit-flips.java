class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int result = 0;
        int flip = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && nums[i - k] == 2) {
                flip -= 1;
            }
            if (flip % 2 == nums[i]) {
                if (i + k > nums.length) {
                    return -1;
                }
                flip += 1;
                result += 1;
                nums[i] = 2;
            }
        }

        return result;
    }
}