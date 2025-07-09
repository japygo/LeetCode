class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                int count = numStack.pop();
                StringBuilder tmp = sb;
                sb = new StringBuilder(strStack.pop());
                while (count-- > 0) {
                    sb.append(tmp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}