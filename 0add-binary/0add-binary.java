class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        while (aIndex >= 0 || bIndex >= 0 || carry > 0) {
            int sum = carry;
            
            if (aIndex >= 0) {
                sum += a.charAt(aIndex--) - '0';
            }
            if (bIndex >= 0) {
                sum += b.charAt(bIndex--) - '0';
            }
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}