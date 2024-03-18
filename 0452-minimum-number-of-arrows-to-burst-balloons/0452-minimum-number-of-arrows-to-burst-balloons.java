class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] > o2[1] ? 1 : -1;
            }
            return o1[0] > o2[0] ? 1 : -1;
        });

        int result = 1;
        int beforeX = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= beforeX) {
                beforeX = Math.min(beforeX, points[i][1]);
                continue;
            }
            beforeX = points[i][1];
            result += 1;
        }

        return result;
    }
}