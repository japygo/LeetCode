class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += count.getOrDefault(sum - goal, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}