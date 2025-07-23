class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case "*": {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}