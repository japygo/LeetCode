class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        List<Integer> list = Arrays.stream(happiness).boxed().sorted(Comparator.reverseOrder()).toList();

        int count = 0;
        for (Integer num : list) {
            if (k == 0) {
                break;
            }

            result += Math.max(num - count, 0);

            k -= 1;
            count += 1;
        }

        return result;
    }
}