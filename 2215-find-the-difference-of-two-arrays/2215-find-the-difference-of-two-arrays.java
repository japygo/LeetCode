class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> result1 = new HashSet<>();
        for (int num : nums1) {
            if (!set2.contains(num)) {
                result1.add(num);
            }
        }
        Set<Integer> result2 = new HashSet<>();
        for (int num : nums2) {
            if (!set1.contains(num)) {
                result2.add(num);
            }
        }
        return List.of(result1.stream().toList(), result2.stream().toList());
    }
}