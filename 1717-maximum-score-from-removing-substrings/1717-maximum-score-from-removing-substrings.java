class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        String first = x > y ? "ab" : "ba";
        String second = x > y ? "ba" : "ab";
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(0) && c == first.charAt(1)) {
                stack.pop();
                result += max;
            } else {
                stack.push(c);
            }
        }

        StringBuilder tmp = new StringBuilder();
        for (char c : stack) {
            tmp.append(c);
        }
        stack.clear();

        for (char c : tmp.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second.charAt(0) && c == second.charAt(1)) {
                stack.pop();
                result += min;
            } else {
                stack.push(c);
            }
        }

        return result;
    }
}