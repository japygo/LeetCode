class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (matrix[j][minIndex] > max) {
                    max = matrix[j][minIndex];
                }
            }

            if (min == max) {
                result.add(min);
            }
        }

        return result;
    }
}