class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean canPush = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() >= asteroid * -1) {
                    canPush = false;
                    if (stack.peek() == asteroid * -1) {
                        stack.pop();
                    }
                    break;
                }
                stack.pop();
            }
            if (canPush) {
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}