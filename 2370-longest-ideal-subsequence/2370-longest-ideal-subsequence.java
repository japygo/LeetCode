class Solution {
    public int longestIdealString(String s, int k) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            int max = arr[index];

            for (int j = Math.max(0, index - k); j < Math.min(26, index + k + 1); j++) {
                max = Math.max(max, arr[j]);
            }

            arr[index] = max + 1;
        }

        return Arrays.stream(arr).max().getAsInt();
    }
}