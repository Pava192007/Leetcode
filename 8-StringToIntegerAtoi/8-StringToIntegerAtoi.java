// Last updated: 10/1/2026, 10:05:46 AM
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        long total = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            int digit = ch - '0';
            total = total * 10 + digit;
            if (sign * total > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * total < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * total);
    }
}