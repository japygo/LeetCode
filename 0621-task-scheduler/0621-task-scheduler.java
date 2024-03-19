class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            int count = map.getOrDefault(task, 0);
            max = Math.max(max, count + 1);
            map.put(task, count + 1);
        }

        int result = (max - 1) * (n + 1);
        for (Integer value : map.values()) {
            if (value == max) {
                result += 1;
            }
        }

        return Math.max(result, tasks.length);
    }
}