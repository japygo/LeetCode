class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        recur(1, k, n, new ArrayList<>(), result);
        return result;
    }
    private void recur(int num, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (list.stream().mapToInt(Integer::intValue).sum() == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if (num > 9) {
            return;
        }
        list.add(num);
        recur(num + 1, k, n, list, result);
        list.remove(Integer.valueOf(num));
        recur(num + 1, k, n, list, result);
    }
}