class Solution {
    public int minimumLength(String s) {
        char[] charArray = s.toCharArray();

        int start = 0;
        int end = charArray.length - 1;
        char before = 0;

        while (start < end) {
            char prefix = charArray[start];
            char suffix = charArray[end];

            if (prefix == suffix) {
                before = prefix;
                start += 1;
                end -= 1;
            } else if (before == prefix) {
                start += 1;
            } else if (before == suffix) {
                end -= 1;
            } else {
                break;
            }
        }
        
        String result = s.substring(start, end + 1);

        if (String.valueOf(before).equals(result)) {
            return 0;
        }

        return result.length();
    }
}