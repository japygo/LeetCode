class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> pStack = new Stack<>();
        Stack<Integer> sStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                pStack.push(i);
            } else if (c == ')') {
                if (!pStack.isEmpty()) {
                    pStack.pop();
                } else if (!sStack.isEmpty()) {
                    sStack.pop();
                } else {
                    return false;
                }
            } else if (c == '*') {
                sStack.push(i);
            }
        }

        while (!pStack.isEmpty() && !sStack.isEmpty()) {
            if (pStack.pop() > sStack.pop()) {
                return false;
            }
        }

        return pStack.isEmpty();
    }
}