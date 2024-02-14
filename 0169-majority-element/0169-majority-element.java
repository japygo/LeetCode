class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}