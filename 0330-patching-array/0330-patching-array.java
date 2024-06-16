class Solution {
    public int minPatches(int[] nums, int n) {
        int result = 0;
        long miss = 1;
        int index = 0;

        while (miss <= n) {
            if (index < nums.length && nums[index] <= miss) {
                miss += nums[index];
                index += 1;
            } else {
                miss += miss;
                result += 1;
            }
        }

        return result;
    }
}