class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int num : nums) {
            sum += num;

            int key = sum % k;
            if (key < 0) {
                key += k;
            }

            if (map.containsKey(key)) {
                int n = map.get(key);
                result += n;
                map.put(key, n + 1);
            } else {
                map.put(key, 1);
            }
        }

        return result;
    }
}