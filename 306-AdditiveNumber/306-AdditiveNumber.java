// Last updated: 10/1/2026, 9:59:11 AM
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            for (int j = 1; n - i - j >= Math.max(i, j); j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, i + j);
                if (isValid(num1, num2, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(String num1, String num2, int k, String num) {
        while (k < num.length()) {
            String sum = addStrings(num1, num2);
            if (!num.startsWith(sum, k)) {
                return false;
            }
            k += sum.length();
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2 + carry;
            
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}