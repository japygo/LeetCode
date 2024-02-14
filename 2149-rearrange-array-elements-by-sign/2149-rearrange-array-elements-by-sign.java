class Solution {
    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int index = 0;
        int pIndex = 0;
        int nIndex = 0;
        boolean isPositive = true;

        while (index < length) {
            if (isPositive) {
                int num = nums[pIndex];
                if (num > 0) {
                    result[index++] = num;
                    isPositive = false;
                }
                pIndex++;
            } else {
                int num = nums[nIndex];
                if (num < 0) {
                    result[index++] = num;
                    isPositive = true;
                }
                nIndex++;
            }
        }

        return result;
    }
}