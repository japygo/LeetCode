class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (i == j) {
                    continue;
                }
                String word = s.substring(i, j);
                if (set.contains(word)) {
                    count += 1;
                } else if (isPalindrome(word)) {
                    count += 1;
                    set.add(word);
                }
            }
        }

        return count;
    }
    
    private boolean isPalindrome(String word) {
        boolean isPalindrome = true;
        char[] charArray = word.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length / 2; i++) {
            if (charArray[i] != charArray[length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}