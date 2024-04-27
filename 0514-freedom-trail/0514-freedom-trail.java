class Solution {
    int[][] dp;
    
    public int findRotateSteps(String ring, String key) {
        dp = new int[ring.length()][key.length()];
        
        return recur(ring, key, 0, 0) + key.length();
    }
    
    private int recur(String ring, String key, int from, int to) {
        if (key.length() == to) {
            return 0;
        }

        if (dp[from][to] != 0) {
            return dp[from][to];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) != key.charAt(to)) {
                continue;
            }

            int index = Math.abs(i - from);
            int count = Math.min(index, ring.length() - index) + recur(ring, key, i, to + 1);

            min = Math.min(min, count);
        }

        dp[from][to] = min;
        return min;
    }
}