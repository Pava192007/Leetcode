// Last updated: 7/25/2026, 2:13:44 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length();
4        int n = t.length();
5        int[] dp = new int[n + 1];
6        dp[0] = 1;
7        for (int i = 1; i <= m; i++) {
8            for (int j = n; j >= 1; j--) {
9                if (s.charAt(i - 1) == t.charAt(j - 1)) {
10                    dp[j] = dp[j] + dp[j - 1];
11                }
12            }
13        }
14        return dp[n];
15    }
16}