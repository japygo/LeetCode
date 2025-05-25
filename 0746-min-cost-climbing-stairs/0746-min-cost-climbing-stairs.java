class Solution {
    public int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(recur(cost, 0), recur(cost, 1));
    }

    private int recur(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        return dp[index] = Math.min(recur(cost, index + 1), recur(cost, index + 2)) + cost[index];
    }
}