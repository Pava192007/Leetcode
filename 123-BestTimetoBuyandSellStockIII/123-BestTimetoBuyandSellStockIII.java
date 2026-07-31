// Last updated: 7/31/2026, 10:28:33 AM
1class Solution {
2    public int trailingZeroes(int n) {
3        int count = 0;
4        while (n > 0) {
5            count += n / 5;
6            n /= 5;
7        }
8        return count;
9    }
10}