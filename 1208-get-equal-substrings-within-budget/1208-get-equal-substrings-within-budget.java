class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0;
        int n = s.length();

        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + costs[i];
        }

        int i = 1;
        int j = 1;
        while (i <= n && j <= n) {
            int cost = sums[j] - sums[i - 1];
            if (cost <= maxCost) {
                result = Math.max(result, j - i + 1);
                j += 1;
            } else {
                i += 1;
            }
        }

        return result;
    }
}