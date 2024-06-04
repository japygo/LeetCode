class Solution {
    public int longestPalindrome(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean hasOdd = false;
        for (Integer count : map.values()) {
            if (count % 2 != 0) {
                result += count - 1;
                hasOdd = true;
            } else {
                result += count;
            }
        }

        if (hasOdd) {
            result += 1;
        }

        return result;
    }
}