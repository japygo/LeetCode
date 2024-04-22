class Solution {
    public int openLock(String[] deadends, String target) {
        int result = -1;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{"0000", "0"});

        while (!queue.isEmpty()) {
            String[] poll = queue.poll();
            StringBuilder lock = new StringBuilder(poll[0]);
            int count = Integer.parseInt(poll[1]);

            if (target.contentEquals(lock)) {
                result = count;
                break;
            }
            count += 1;

            if (visited.contains(lock.toString())) {
                continue;
            }
            visited.add(lock.toString());

            for (int i = 0; i < 4; i++) {
                StringBuilder tmp = new StringBuilder(lock);
                tmp.setCharAt(i, up(Character.getNumericValue(tmp.charAt(i))));
                if (visited.contains(tmp.toString())) {
                    continue;
                }
                queue.add(new String[]{tmp.toString(), String.valueOf(count)});
            }

            for (int i = 0; i < 4; i++) {
                StringBuilder tmp = new StringBuilder(lock);
                tmp.setCharAt(i, down(Character.getNumericValue(tmp.charAt(i))));
                if (visited.contains(tmp.toString())) {
                    continue;
                }
                queue.add(new String[]{tmp.toString(), String.valueOf(count)});
            }
        }

        return result;
    }
    
    private char up(int num) {
        return Character.forDigit((num + 1) % 10, 10);
    }

    private char down(int num) {
        return Character.forDigit((num + 9) % 10, 10);
    }
}