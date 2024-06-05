class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> tmp = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                tmp.put(c, tmp.getOrDefault(c, 0) + 1);
            }

            for (char c : map.keySet()) {
                if (tmp.containsKey(c)) {
                    map.put(c, Math.min(map.get(c), tmp.get(c)));
                } else {
                    map.put(c, 0);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }

        return result;
    }
}