class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.' ) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
            for (Integer value : map.values()) {
                if (value > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
            for (Integer value : map.values()) {
                if (value > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Map<Character, Integer> map = new HashMap<>();
                for (int k = 0; k < 9; k++) {
                    char c = board[i * 3 + k / 3][j * 3 + k % 3];
                    if (c != '.') {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                    }
                }
                for (Integer value : map.values()) {
                    if (value > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}