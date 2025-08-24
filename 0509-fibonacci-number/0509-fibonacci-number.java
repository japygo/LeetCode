class Solution {
    public Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n < 2) {
            return n;
        }
        int result = fib(n - 1) + fib(n - 2);
        map.put(n, result);
        return result;
    }
}