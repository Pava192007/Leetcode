// Last updated: 8/4/2026, 8:59:25 AM
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6        int i = 0;
7        int n = s.length();
8        while (i < n && s.charAt(i) == ' ') {
9            i++;
10        }
11        if (i == n) {
12            return 0;
13        }
14        int sign = 1;
15        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
16            sign = (s.charAt(i) == '-') ? -1 : 1;
17            i++;
18        }
19        long total = 0;
20        while (i < n) {
21            char ch = s.charAt(i);
22            if (ch < '0' || ch > '9') {
23                break;
24            }
25            int digit = ch - '0';
26            total = total * 10 + digit;
27            if (sign * total > Integer.MAX_VALUE) {
28                return Integer.MAX_VALUE;
29            }
30            if (sign * total < Integer.MIN_VALUE) {
31                return Integer.MIN_VALUE;
32            }
33            i++;
34        }
35        return (int) (sign * total);
36    }
37}