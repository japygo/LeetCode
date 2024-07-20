class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        int[] currentRowSum = new int[rowSum.length];
        int[] currentColSum = new int[colSum.length];

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                result[i][j] = Math.min(rowSum[i] - currentRowSum[i], colSum[j] - currentColSum[j]);
                currentRowSum[i] += result[i][j];
                currentColSum[j] += result[i][j];
            }
        }

        return result;
    }
}