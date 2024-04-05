class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!result.isEmpty() &&
                    c != result.charAt(result.length() - 1) &&
                    Character.toLowerCase(c) == Character.toLowerCase(result.charAt(result.length() - 1))) {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}