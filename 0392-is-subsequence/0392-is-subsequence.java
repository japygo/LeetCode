class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == sChars[index]) {
                index++;
                if (index == sChars.length) {
                    return true;
                }
            }
        }
        return false;
    }
}