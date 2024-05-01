class Solution {
    public String reversePrefix(String word, char ch) {
        if (!word.contains(String.valueOf(ch))) {
            return word;
        }

        StringBuilder result = new StringBuilder();
        int index = word.indexOf(String.valueOf(ch)) + 1;
        for (int i = 0; i < index; i++) {
            result.insert(0, word.charAt(i));
        }
        result.append(word.substring(index));

        return result.toString();
    }
}