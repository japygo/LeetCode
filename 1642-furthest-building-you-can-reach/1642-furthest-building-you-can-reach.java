class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int length = heights.length;
        int result = length - 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 1; i < length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) {
                continue;
            }
            
            queue.add(diff);
            if (queue.size() <= ladders) {
                continue;
            }
            
            bricks -= queue.poll();
            if (bricks < 0) {
                result = i - 1;
                break;
            }
        }
        return result;
    }
}