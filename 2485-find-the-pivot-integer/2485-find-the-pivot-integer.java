class Solution {
    public int pivotInteger(int n) {
        int x = n;
        while (x >= 0) {
            int sum1 = 0;
            for (int i = 1; i <= x; i++) {
                sum1 += i;
            }

            int sum2 = 0;
            for (int i = x; i <= n; i++) {
                sum2 += i;
            }

            if (sum1 == sum2) {
                return x;
            }
            x -= 1;
        }

        return x;
    }
}