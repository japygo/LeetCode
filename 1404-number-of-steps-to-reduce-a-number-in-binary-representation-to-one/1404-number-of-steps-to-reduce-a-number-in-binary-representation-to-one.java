class Solution {
    public int numSteps(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
            result += 1;
        }

        if (sb.toString().equals("1")) {
            return result;
        }

        for (char c : sb.toString().toCharArray()) {
            result += c == '1' ? 1 : 2;
        }

        return result + 1;
    }
}