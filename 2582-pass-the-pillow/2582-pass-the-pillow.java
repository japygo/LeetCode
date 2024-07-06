class Solution {
    public int passThePillow(int n, int time) {
        if (n == time) {
            return time - 1;
        }

        if (n > time) {
            return time + 1;
        }

        int div = time / (n - 1);
        int mod = time % (n - 1);

        if (div % 2 == 0) {
            return mod + 1;
        }

        return n - mod;
    }
}