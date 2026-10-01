// Last updated: 10/1/2026, 9:48:27 AM
1class Solution {
2    public int integerBreak(int n) {
3        if (n == 2) return 1; 
4        if (n == 3) return 2;
5        int product = 1;
6        while (n > 4) {
7            product *= 3;
8            n -= 3;
9        }
10        return product * n;
11    }
12}