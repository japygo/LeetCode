class Solution {
    public int minOperations(int[] nums, int k) {
        return Integer.bitCount(k ^ Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt());
    }
}