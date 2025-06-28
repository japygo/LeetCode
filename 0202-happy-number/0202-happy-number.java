class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        String num = String.valueOf(n);
        while (true) {
            int next = 0;
            for (int i = 0; i < num.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
                next += digit * digit;
            }
            if (next == 1) {
                return true;
            }
            if (set.contains(next)) {
                return false;
            }
            set.add(next);
            num = String.valueOf(next);
        }
    }
}