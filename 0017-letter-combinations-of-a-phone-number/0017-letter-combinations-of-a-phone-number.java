class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();
        recur(digits, map, 0, "", result);
        return result;
    }
    private void recur(String digits, Map<Character, List<String>> map, int index, String comb, List<String> result) {
        if (index >= digits.length()) {
            result.add(comb);
            return;
        }
        List<String> letters = map.get(digits.charAt(index));
        for (String letter : letters) {
            recur(digits, map, index + 1, comb + letter, result);
        }
    }
}