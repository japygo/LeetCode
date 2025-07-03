class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int result = 0;
        while (index < chars.length) {
            int count = 1;
            while (index + count < chars.length && chars[index + count] == chars[index]) {
                count++;
            }
            chars[result++] = chars[index];
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[result++] = c;
                }
            }
            index += count;
        }
        return result;
    }
}