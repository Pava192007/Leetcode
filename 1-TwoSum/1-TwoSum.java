// Last updated: 7/17/2026, 3:01:18 PM
1class Solution {
2    public int reverseBits(int n) {
3        int ans = 0;
4        for (int i = 0; i < 32; i++) {
5            ans <<= 1;
6            ans |= (n & 1);
7            n >>>= 1;        
8        }
9        return ans;
10    }
11}