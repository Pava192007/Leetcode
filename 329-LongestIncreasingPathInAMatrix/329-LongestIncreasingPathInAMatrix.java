// Last updated: 10/1/2026, 9:59:00 AM
class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }
    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        int maxLength = 1;
        for (int[] dir : DIRECTIONS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if (newRow >= 0 && newRow < matrix.length && 
                newCol >= 0 && newCol < matrix[0].length && 
                matrix[newRow][newCol] > matrix[r][c]) {    
                int length = 1 + dfs(matrix, newRow, newCol, memo);
                maxLength = Math.max(maxLength, length);
            }
        }
        memo[r][c] = maxLength;
        return maxLength;
    }
}