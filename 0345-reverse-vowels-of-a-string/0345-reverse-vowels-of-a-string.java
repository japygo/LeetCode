class Solution {
    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c)) {
                vowels.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c)) {
                sb.append(vowels.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}