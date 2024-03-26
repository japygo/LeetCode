class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;

        Arrays.sort(nums);

        for (int num : nums) {
            if (num < result) {
                continue;
            }
            if (num == result) {
                result += 1;
                continue;
            }
            break;
        }

        return result;
    }
}