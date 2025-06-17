class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            int a = str1.length();
            int b = str2.length();
            int c = a % b;
            while (c != 0) {
                a = b;
                b = c;
                c = a % b;
            }
            return str1.substring(0, b);
    }
}