class Solution {
    public int maxDistance(int[] position, int m) {
        int result = 0;
        int n = position.length;

        Arrays.sort(position);

        int start = 1;
        int end = position[n - 1] - position[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int prev = position[0];
            int count = 1;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - prev >= mid) {
                    prev = position[i];
                    count += 1;
                }
            }

            if (count >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}