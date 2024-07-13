class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        PriorityQueue<Robot> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.position));
        for (int i = 0; i < n; i++) {
            queue.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }

        Stack<Robot> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();

            boolean isRemoved = false;
            while (!stack.isEmpty() && stack.peek().direction == 'R' && robot.direction == 'L') {
                isRemoved = true;
                Robot pop = stack.pop();
                if (pop.health < robot.health) {
                    robot.health -= 1;
                    isRemoved = false;
                } else {
                    if (pop.health > robot.health) {
                        pop.health -= 1;
                        stack.add(pop);
                    }
                    break;
                }
            }

            if (!isRemoved) {
                stack.add(robot);
            }
        }

        return stack.stream()
                .sorted(Comparator.comparingInt(o -> o.index))
                .map(robot -> robot.health)
                .toList();
    }
    
    class Robot {
        private final int index;
        private final int position;
        private int health;
        private final char direction;

        public Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
}