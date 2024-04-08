class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.add(student);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        int failCount = 0;
        while (!queue.isEmpty()) {
            if (failCount == queue.size()) {
                break;
            }
            int student = queue.poll();
            if (student == stack.peek()) {
                stack.pop();
                failCount = 0;
            } else {
                queue.add(student);
                failCount++;
            }
        }

        return failCount;
    }
}