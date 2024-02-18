class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            emptyRooms.add(i);
        }
        PriorityQueue<Room> useRooms = new PriorityQueue<>((o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.id - o2.id;
            }
            return o1.time - o2.time;
        });

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!useRooms.isEmpty() && useRooms.peek().isUse(start)) {
                emptyRooms.add(useRooms.poll().id);
            }

            int id;
            if (!emptyRooms.isEmpty()) {
                id = emptyRooms.poll();
                useRooms.add(new Room(id, end));
            } else {
                Room room = useRooms.poll();
                id = room.id;
                room.use(start, end);
                useRooms.add(room);
            }
            count[id] += 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[result] < count[i]) {
                result = i;
            }
        }
        return result;
    }
    
    static class Room {
        private int id;
        private int time;

        public Room(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public void use(int start, int end) {
            this.time = this.time - start + end;
        }

        public boolean isUse(int time) {
            return this.time <= time;
        }
    }
}