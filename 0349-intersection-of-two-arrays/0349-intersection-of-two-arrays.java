class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

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
                set.add(num1);
                i += 1;
                j += 1;
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}