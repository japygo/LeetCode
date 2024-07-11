class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                arr[i] = j;
                arr[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        int direction = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                direction *= -1;
                index = arr[index];
            } else {
                result.append(s.charAt(index));
            }
            index += direction;
        }

        return result.toString();
    }
}