class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int i = 0;
        int j = 0;

        while (i < nums.length && j < nums.length) {
            if (map.getOrDefault(nums[j], 0) == 0) {
                k -= 1;
            }
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            j += 1;

            if (k < 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                k += 1;
                i += 1;
                count = 0;
            }

            if (k == 0) {
                while (map.getOrDefault(nums[i], 0) > 1) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                    i += 1;
                    count += 1;
                }
                result += (count + 1);
            }
        }

        return result;
    }
}