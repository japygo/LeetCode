class Solution {
    int result;
    
    public int subsetXORSum(int[] nums) {
        result = 0;
        recur(nums, 0, 0);
        return result;
    }
    
    private void recur(int[] nums, int index, int xor) {
        if (index == nums.length) {
            result += xor;
            return;
        }

        recur(nums, index + 1, xor);
        recur(nums, index + 1, xor ^ nums[index]);
    }
}