class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int result = -1;

        int start = 1;
        int end = 1;
        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            int flowerCount = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    flowerCount += 1;
                } else {
                    flowerCount = 0;
                }

                if (flowerCount == k) {
                    count += 1;
                    flowerCount = 0;
                }
            }

            if (count >= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}