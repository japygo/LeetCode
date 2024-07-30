class Solution {
    public void duplicateZeros(int[] arr) {
        int last = arr.length - 1;
        int count = 0;
        for (int i = 0; i <= last - count; i++) {
            if (arr[i] == 0) {
                if (last - count == i) {
                    arr[last] = 0;
                    last--;
                    break;
                }
                count++;
            }
        }
        
        for (int i = last - count; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[i + count] = arr[i];
            } else {
                arr[i + count] = 0;
                count--;
                arr[i + count] = 0;
            }
        }
    }
}