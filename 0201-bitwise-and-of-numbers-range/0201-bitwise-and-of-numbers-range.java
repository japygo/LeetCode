class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0) {
            return 0;
        }
        if (left == right) {
            return left;
        }

        int l = log2(left);
        int r = log2(right);
        if (l != r) {
            return 0;
        }

        String ls = Integer.toBinaryString(left);
        String rs = Integer.toBinaryString(right);

        int result = 0;
        for (int i = 0; i < ls.length() - 1; i++) {
            if (ls.charAt(i) == rs.charAt(i)) {
                if (ls.charAt(i) == 49) {
                    result += (int) Math.pow(2, ls.length() - i - 1);
                }
            } else {
                break;
            }
        }

        return result;
    }
    
    private int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }
}