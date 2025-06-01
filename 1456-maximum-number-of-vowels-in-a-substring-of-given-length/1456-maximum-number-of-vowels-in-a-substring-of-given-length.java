class Solution {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[chars.length + 1];
        count[0] = 0;
        for (int i = 0; i < chars.length; i++) {
            count[i + 1] = count[i];
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                count[i + 1] += 1;
            }
        }
        int max = 0;
        for (int i = k; i < count.length; i++) {
            max = Math.max(max, count[i] - count[i - k]);
        }
        return max;
    }
}