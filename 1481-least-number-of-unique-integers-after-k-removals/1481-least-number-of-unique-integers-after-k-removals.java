class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.merge(a, 1, Integer::sum);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            if (k < 0) {
                result = list.size() - i;
                break;
            }
        }

        return result;
    }
}