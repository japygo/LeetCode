class Solution {
    List<String> result;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        recur(s, wordDict, 0, new ArrayList<>());
        return result;
    }
    
    private void recur(String s, List<String> wordDict, int index, List<String> words) {
        if (index == s.length()) {
            result.add(String.join(" ", words));
            return;
        }

        for (int i = index; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (wordDict.contains(substring)) {
                words.add(substring);
                recur(s, wordDict, i, words);
                words.remove(words.size() - 1);
            }
        }
    }
}