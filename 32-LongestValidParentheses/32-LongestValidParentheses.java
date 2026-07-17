// Last updated: 7/17/2026, 9:10:37 AM
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                }
                else {
                    int j = i - dp[i - 1] - 1;
                    if (j > 0 && s.charAt(j - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[j - 1];
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}