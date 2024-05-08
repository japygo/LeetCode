class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{score[i], i});
        }

        int rank = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll()[1];
            rank += 1;
            answer[index] = switch (rank) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> String.valueOf(rank);
            };
        }

        return answer;
    }
}