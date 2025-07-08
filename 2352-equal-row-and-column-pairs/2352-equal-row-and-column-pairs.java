class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
                col.add(grid[j][i]);
            }
            rowMap.put(i, row);
            colMap.put(i, col);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> row = rowMap.get(i);
            for (int j = 0; j < n; j++) {
                List<Integer> col = colMap.get(j);
                if (row.equals(col)) {
                    count++;
                }
            }
        }
        return count;
    }
}