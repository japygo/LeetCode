class Solution {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        recur(s, 0, new ArrayList<>());
        return result;
    }
    
    private void recur(String s, int index, List<String> list) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (sub.contentEquals(new StringBuilder(sub).reverse())) {
                list.add(sub);
                recur(s, i, new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
    }
}