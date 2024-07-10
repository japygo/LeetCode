class Solution {
    public int minOperations(String[] logs) {
        int result = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                if (result > 0) {
                    result -= 1;
                }
            } else if (!log.equals("./")) {
                result += 1;
            }
        }

        return result;
    }
}