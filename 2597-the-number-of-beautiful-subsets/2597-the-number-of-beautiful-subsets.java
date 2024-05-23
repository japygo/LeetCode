class Solution {
    int result;
    
    public int beautifulSubsets(int[] nums, int k) {
        result = 0;
        recur(nums, k, 0, new ArrayList<>());
        return result;
    }
    
    private void recur(int[] nums, int k, int index, List<Integer> list) {
        if (index == nums.length) {
            if (!list.isEmpty()) {
                result += 1;
            }
            return;
        }

        boolean isBeautiful = false;
        for (Integer i : list) {
            if (Math.abs(i - nums[index]) == k) {
                isBeautiful = true;
                break;
            }
        }

        if (!isBeautiful) {
            list.add(nums[index]);
            recur(nums, k, index + 1, list);
            list.remove(list.size() - 1);
        }
        recur(nums, k, index + 1, list);
    }
}