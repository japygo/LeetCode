class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        
        int last = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[last--] = nums2[j--];
            } else {
                nums1[last--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[last--] = nums2[j--];
        }
    }
}