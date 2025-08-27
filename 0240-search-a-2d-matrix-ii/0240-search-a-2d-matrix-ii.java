class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
    private boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }

        int midRow = rowStart + (rowEnd - rowStart) / 2;
        int midCol = colStart + (colEnd - colStart) / 2;

        int pivot = matrix[midRow][midCol];

        if (pivot == target) {
            return true;
        } else if (pivot < target) {
            return search(matrix, target, rowStart, midRow, midCol + 1, colEnd) ||
                    search(matrix, target, midRow + 1, rowEnd, colStart, midCol) ||
                    search(matrix, target, midRow + 1, rowEnd, midCol + 1, colEnd);
        } else {
            return search(matrix, target, rowStart, midRow - 1, colStart, midCol - 1) ||
                    search(matrix, target, rowStart, midRow - 1, midCol, colEnd) ||
                    search(matrix, target, midRow, rowEnd, colStart, midCol - 1);
        }
    }
}