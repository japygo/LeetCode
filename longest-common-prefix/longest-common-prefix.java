class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        String s = strs[0];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        
        return result.toString();
    }
}