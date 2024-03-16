class Solution {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            result = Math.max(result, i - map.getOrDefault(sum, i));
            map.putIfAbsent(sum, i);
        }

        return result;
    }
}