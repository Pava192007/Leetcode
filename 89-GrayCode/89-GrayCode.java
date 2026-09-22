// Last updated: 9/22/2026, 9:20:02 AM
1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        List<Integer> result = new ArrayList<>();
4        if (matrix == null || matrix.length == 0) {
5            return result;
6        }
7        int top = 0;
8        int bottom = matrix.length - 1;
9        int left = 0;
10        int right = matrix[0].length - 1;
11        while (top <= bottom && left <= right) {
12            for (int col = left; col <= right; col++) {
13                result.add(matrix[top][col]);
14            }
15            top++;
16            for (int row = top; row <= bottom; row++) {
17                result.add(matrix[row][right]);
18            }
19            right--;
20            if (top <= bottom) {
21                for (int col = right; col >= left; col--) {
22                    result.add(matrix[bottom][col]);
23                }
24                bottom--; 
25            }
26            if (left <= right) {
27                for (int row = bottom; row >= top; row--) {
28                    result.add(matrix[row][left]);
29                }
30                left++; 
31            }
32        }
33        return result;
34    }
35}