class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int result = -1;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 < num2) {
                i += 1;
            } else if (num1 > num2) {
                j += 1;
            } else {
                result = num1;
                break;
            }
        }
        return result;
    }
}