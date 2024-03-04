class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int score = 0;
        int start = 0;
        int end = tokens.length - 1;

        while (start <= end) {
            int s = tokens[start];
            int e = tokens[end];

            if (power >= s) {
                power -= s;
                start += 1;
                score += 1;
            } else if (score > 0 && start != end) {
                power += e;
                end -= 1;
                score -= 1;
            } else {
                break;
            }
        }

        return score;
    }
}