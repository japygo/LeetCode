class Solution {
    public boolean judgeSquareSum(int c) {
        long i = (long) Math.sqrt(c);
        if (i * i == c) {
            return true;
        }

        long j = 1;
        while (j <= i) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                j += 1;
            } else {
                i -= 1;
            }
        }

        return false;
    }
}