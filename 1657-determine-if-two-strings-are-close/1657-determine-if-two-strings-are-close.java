class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>(map1.keySet());
        for (Character key : map2.keySet()) {
            if (!set.contains(key)) {
                return false;
            }
        }
        return map1.values().stream().sorted().toList().equals(map2.values().stream().sorted().toList());
    }
}