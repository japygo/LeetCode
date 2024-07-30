class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int num : nums) {
            if (num > nums[index - 1]) {
                nums[index++] = num;
            }
        }
        
        return index;
    }
}