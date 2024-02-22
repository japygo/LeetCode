class Solution {
    public int findJudge(int n, int[][] trust) {
        int result = -1;

        int[] people = new int[n + 1];
        int[] judge = new int[n + 1];

        for (int[] t : trust) {
            people[t[0]] += 1;
            judge[t[1]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            if (people[i] == 0 && judge[i] == n - 1) {
                if (result == -1) {
                    result = i;
                } else {
                    result = -1;
                }
            }
        }

        return result;
    }
}