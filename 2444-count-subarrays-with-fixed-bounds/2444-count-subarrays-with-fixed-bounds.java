class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int index = -1;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < minK || num > maxK) {
                index = i;
            }
            if (num == minK) {
                minIndex = i;
            }
            if (num == maxK) {
                maxIndex = i;
            }
            result += Math.max(0, Math.min(minIndex, maxIndex) - index);
        }

        return result;
    }
}