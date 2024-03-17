class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> result = new ArrayList<>();
        int index = 0;

        while (index < intervals.length) {
            if (newInterval[0] <= intervals[index][1]) {
                break;
            }
            result.add(intervals[index]);
            index += 1;
        }

        while (index < intervals.length) {
            if (newInterval[1] < intervals[index][0]) {
                break;
            }
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index += 1;
        }

        result.add(newInterval);

        while (index < intervals.length) {
            result.add(intervals[index]);
            index += 1;
        }

        return result.toArray(int[][]::new);
    }
}