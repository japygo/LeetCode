class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int key = sum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) > 1) {
                    return true;
                }
            } else {
                map.put(key, i);
            }
        }

        return false;
    }
}