class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        while (left < right) {
            if (maxLeft <= maxRight) {
                result += maxLeft - height[left];
                left += 1;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                result += maxRight - height[right];
                right -= 1;
                maxRight = Math.max(maxRight, height[right]);
            }
        }

        return result;
    }
}