class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for (int i = 2; i < rowIndex + 1; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        return Arrays.stream(arr[rowIndex]).boxed().toList();
    }
}