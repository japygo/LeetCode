class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;

        while (start <= end) {
            int s = nums[start] * nums[start];
            int e = nums[end] * nums[end];
            if (s < e) {
                result[index] = e;
                end -= 1;
            } else {
                result[index] = s;
                start += 1;
            }
            index -= 1;
        }

        return result;
    }
}