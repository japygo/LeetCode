class Solution {
    public String firstPalindrome(String[] words) {
        String result = "";

        for (String word : words) {
            boolean isPalindrome = true;
            char[] charArray = word.toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length / 2; i++) {
                if (charArray[i] != charArray[length - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                result = word;
                break;
            }
        }

        return result;
    }
}