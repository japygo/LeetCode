class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }
        
        int top = 0;
        for (int i = 0; i < arr.length; i++) {
            top = Math.max(top, arr[i]);
        }
        
        boolean isTop = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            
            if (i != 0 && arr[i] == top) {
                isTop = true;
            }
            
            if (arr[i] < arr[i + 1]) {
                if (isTop) {
                    return false;
                }
            } else if (arr[i] > arr[i + 1]) {
                if (!isTop) {
                    return false;
                }
            }
        }
        
        return isTop;
    }
}