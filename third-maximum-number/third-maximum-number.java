class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        
        for (int num : nums) {
            if (num == first || num == second || num == third) {
                continue;
            }
            
            if (first < num) {
                third = second;
                second = first;
                first = num;
            } else if (second < num) {
                third = second;
                second = num;
            } else if (third < num) {
                third = num;
            }
        }
        
        if (third == Long.MIN_VALUE) {
            return (int) first;
        }
        
        return (int) third;
    }
}