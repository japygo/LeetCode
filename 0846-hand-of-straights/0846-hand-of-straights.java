class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            int key = map.entrySet().iterator().next().getKey();

            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(key + i)) {
                    return false;
                }

                map.put(key + i, map.get(key + i) - 1);

                if (map.get(key + i) == 0) {
                    map.remove(key + i);
                }
            }
        }

        return true;
    }
}