class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char stone : stones.toCharArray()) {
            map.put(stone, map.getOrDefault(stone, 0) + 1);
        }
        int result = 0;
        for (char jewel : jewels.toCharArray()) {
            result += map.getOrDefault(jewel, 0);
        }
        return result;
    }
}