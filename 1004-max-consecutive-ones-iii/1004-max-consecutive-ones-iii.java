class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int count = 0;
        int startIndex = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (k > 0) {
                    k--;
                    count++;
                } else {
                    while (nums[startIndex] == 1) {
                        startIndex++;
                        count--;
                    }
                    startIndex++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}