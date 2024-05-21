class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        recur(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void recur(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        recur(nums, index + 1, list);
        list.remove(list.size() - 1);
        recur(nums, index + 1, list);
    }
}