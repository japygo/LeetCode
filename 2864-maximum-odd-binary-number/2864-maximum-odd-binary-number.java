class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count0 = 0;
        int count1 = 0;
        String[] split = s.split("");
        for (String string : split) {
            if (string.equals("0")) {
                count0 += 1;
            } else {
                count1 += 1;
            }
        }

        count1 -= 1;
        StringBuilder result = new StringBuilder("1");
        for (int i = 0; i < count0; i++) {
            result.insert(0, "0");
        }
        for (int i = 0; i < count1; i++) {
            result.insert(0, "1");
        }

        return result.toString();
    }
}