class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String str : s.split(" ")) {
            for (int i = str.length() - 1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}