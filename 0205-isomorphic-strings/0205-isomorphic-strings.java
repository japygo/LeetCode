class Solution {
    public boolean isIsomorphic(String s, String t) {
        boolean result = true;
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            Character sCharacter = sMap.get(sChar);
            Character tCharacter = tMap.get(tChar);

            if (sCharacter == null) {
                sMap.put(sChar, tChar);
            } else {
                if (sCharacter != tChar) {
                    result = false;
                    break;
                }
            }

            if (tCharacter == null) {
                tMap.put(tChar, sChar);
            } else {
                if (tCharacter != sChar) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}