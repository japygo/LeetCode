class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        boolean result = true;
        for (char c : ransomNote.toCharArray()) {
            Integer count = map.get(c);
            if (count == null || count == 0) {
                result = false;
                break;
            }
            map.put(c, count - 1);
        }
        
        return result;
    }
}