class Solution {
    int result;
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        result = 0;
        int[] lettersCount = new int[26];
        for (char letter : letters) {
            lettersCount[letter - 'a'] += 1;
        }

        recur(words, score, lettersCount, new int[26], 0, 0);

        return result;
    }
    
    private void recur(String[] words, int[] score, int[] lettersCount, int[] count, int index, int sum) {
        for (int i = 0; i < 26; i++) {
            if (lettersCount[i] < count[i]) {
                return;
            }
        }

        result = Math.max(result, sum);

        for (int i = index; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                count[c - 'a'] += 1;
                sum += score[c - 'a'];
            }

            recur(words, score, lettersCount, count, i + 1, sum);

            for (char c : words[i].toCharArray()) {
                count[c - 'a'] -= 1;
                sum -= score[c - 'a'];
            }
        }
    }
}