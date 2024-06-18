class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        int n = difficulty.length;

        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }

        jobs.sort(Comparator.comparingInt(o -> o[0]));
        Arrays.sort(worker);

        int index = 0;
        int max = 0;
        for (int w : worker) {
            while (index < n) {
                int[] job = jobs.get(index);
                if (w >= job[0]) {
                    max = Math.max(max, job[1]);
                    index += 1;
                } else {
                    break;
                }
            }
            result += max;
        }

        return result;
    }
}