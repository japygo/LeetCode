class Solution {
    public int[] frequencySort(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = map.keySet().stream().sorted((o1, o2) -> {
            int n1 = map.get(o1);
            int n2 = map.get(o2);
            if (n1 == n2) {
                return o2 - o1;
            }
            return n1 - n2;
        }).toList();

        int index = 0;
        for (int key : list) {
            for (int i = 0; i < map.get(key); i++) {
                result[index++] = key;
            }
        }

        return result;
    }
}