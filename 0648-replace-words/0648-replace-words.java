class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        Set<String> set = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");

        for (String word : words) {
            boolean isChanged = false;
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.substring(0, i))) {
                    isChanged = true;
                    result.append(word, 0, i);
                    break;
                }
            }
            if (!isChanged) {
                result.append(word);
            }
            result.append(" ");
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }
}