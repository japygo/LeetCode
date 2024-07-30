class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        int index = 0;
        int end = arr.length - 1;
        
        while (index < end && arr[index] < arr[index + 1]) {
            index++;
        }
        
        if (index == 0 || index == end) {
            return false;
        }
        
        while (index < end && arr[index] > arr[index + 1]) {
            index++;
        }
        
        return index == end;
    }
}