class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int result = 0;
        int n = customers.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }

        result = sum;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                sum -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            result = Math.max(result, sum);
        }

        return result;
    }
}