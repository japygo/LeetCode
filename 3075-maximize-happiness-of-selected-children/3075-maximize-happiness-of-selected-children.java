class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        Arrays.sort(happiness);
        int count = 0;

        for (int i = happiness.length - 1; i > happiness.length - 1 - k; i--) {
            result += Math.max(happiness[i] - count, 0);
            count += 1;
        }

        return result;
    }
}