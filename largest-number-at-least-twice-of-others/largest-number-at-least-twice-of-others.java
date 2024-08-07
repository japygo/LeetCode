class Solution {
    public int dominantIndex(int[] nums) {
        int first = 0;
        int second = 0;
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (first < num) {
                second = first;
                first = num;
                index = i;
            } else if (second < num) {
                second = num;
            }
        }
        
        if (first >= 2 * second) {
            return index;
        }
        
        return -1;
    }
}