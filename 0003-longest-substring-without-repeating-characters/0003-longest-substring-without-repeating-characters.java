class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                set.remove(s.charAt(start++));
            } else {
                set.add(c);
                max = Math.max(max, set.size());
                end++;
            }
        }
        return max;
    }
}