class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) == k + 1) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                i += 1;
            }
            result = Math.max(result, j - i + 1);
            j += 1;
        }

        return result;
    }
}