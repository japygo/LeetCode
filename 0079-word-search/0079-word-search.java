class Solution {
    boolean result;
    boolean[][] visited;
    int maxM;
    int maxN;
    public boolean exist(char[][] board, String word) {
        result = false;
        maxM = board.length;
        maxN = board[0].length;

        for (int m = 0; m < maxM; m++) {
            for (int n = 0; n < maxN; n++) {
                visited = new boolean[maxM][maxN];
                recur(m, n, 0, board, word);
                if (result) {
                    break;
                }
            }
        }

        return result;
    }
    
    private void recur(int m, int n, int index, char[][] board, String word) {
        if (board[m][n] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            result = true;
            return;
        }

        int[] dm = new int[]{1, -1, 0, 0};
        int[] dn = new int[]{0, 0, 1, -1};

        visited[m][n] = true;
        for (int i = 0; i < 4; i++) {
            int nm = m + dm[i];
            int nn = n + dn[i];
            if (nm < 0 || nm >= board.length ||
                    nn < 0 || nn >= board[0].length ||
                    visited[nm][nn]) {
                continue;
            }
            recur(nm, nn, index + 1, board, word);
        }
        visited[m][n] = false;
    }
}