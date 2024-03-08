class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Integer i = map.getOrDefault(num, 0);
            map.put(num, i + 1);
            max = Math.max(max, i + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                count += 1;
            }
        }

        return count * max;
    }
}