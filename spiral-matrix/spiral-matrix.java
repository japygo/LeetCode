class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        
        int rStart = 0;
        int rEnd = m - 1;
        int cStart = 0;
        int cEnd = n - 1;
        
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int c = cStart; c <= cEnd; c++) {
                result.add(matrix[rStart][c]);
            }
            rStart++;
            
            for (int r = rStart; r <= rEnd; r++) {
                result.add(matrix[r][cEnd]);
            }
            cEnd--;
            
            if (rStart <= rEnd) {
                for (int c = cEnd; c >= cStart; c--) {
                    result.add(matrix[rEnd][c]);
                }
            }
            rEnd--;
            
            if (cStart <= cEnd) {
                for (int r = rEnd; r >= rStart; r--) {
                    result.add(matrix[r][cStart]);
                }
            }
            cStart++;
        }
        
        return result;
    }
}