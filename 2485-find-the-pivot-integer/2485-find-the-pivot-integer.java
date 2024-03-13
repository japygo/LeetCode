class Solution {
    public int pivotInteger(int n) {
        int result = -1;

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }

        for (int i = 1; i <= n; i++) {
            if (sum[i] == sum[n] - sum[i] + i) {
                result = i;
                break;
            }
        }

        return result;
    }
}