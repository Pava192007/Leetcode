// Last updated: 10/1/2026, 9:14:08 AM
1class NumMatrix {
2    private int[][] dp;
3    public NumMatrix(int[][] matrix) {
4        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
5        int m = matrix.length;
6        int n = matrix[0].length;
7        dp = new int[m + 1][n + 1];
8        for (int i = 1; i <= m; i++) {
9            for (int j = 1; j <= n; j++) {
10                dp[i][j] = matrix[i - 1][j - 1] 
11                         + dp[i - 1][j] 
12                         + dp[i][j - 1] 
13                         - dp[i - 1][j - 1];
14            }
15        }
16    }
17    public int sumRegion(int row1, int col1, int row2, int col2) {
18        return dp[row2 + 1][col2 + 1] 
19             - dp[row1][col2 + 1] 
20             - dp[row2 + 1][col1] 
21             + dp[row1][col1];
22    }
23}
24
25/**
26 * Your NumMatrix object will be instantiated and called as such:
27 * NumMatrix obj = new NumMatrix(matrix);
28 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
29 */