class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character pop = stack.pop();
            if (c == ')' && pop != '(') {
                return false;
            }
            if (c == ']' && pop != '[') {
                return false;
            }
            if (c == '}' && pop != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}