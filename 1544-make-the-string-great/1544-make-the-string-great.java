class Solution {
    public String makeGood(String s) {
        boolean isFinish = false;

        while (!isFinish) {
            isFinish = true;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1) && 
                        Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i + 1))) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    isFinish = false;
                    break;
                }
            }
        }

        return s;
    }
}