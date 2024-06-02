class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            if (s[i] != s[j]) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
            i += 1;
            j -= 1;
        }
    }
}