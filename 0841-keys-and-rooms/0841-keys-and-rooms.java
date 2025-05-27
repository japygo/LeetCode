class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        recur(rooms, visited, 0);
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }
    private void recur(List<List<Integer>> rooms, boolean[] visited, int index) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;

        List<Integer> keys = rooms.get(index);
        for (int key : keys) {
            recur(rooms, visited, key);
        }
    }
}