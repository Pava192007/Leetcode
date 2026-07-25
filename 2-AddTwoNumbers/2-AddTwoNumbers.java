// Last updated: 7/25/2026, 2:11:19 PM
1import java.util.ArrayDeque;
2import java.util.Deque;
3
4class Solution {
5    public int maximalRectangle(char[][] matrix) {
6        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
7            return 0;
8        }
9
10        int rows = matrix.length;
11        int cols = matrix[0].length;
12        int[] heights = new int[cols];
13        int maxArea = 0;
14
15        for (int i = 0; i < rows; i++) {
16            // Update histogram heights for the current row
17            for (int j = 0; j < cols; j++) {
18                if (matrix[i][j] == '1') {
19                    heights[j]++;
20                } else {
21                    heights[j] = 0;
22                }
23            }
24
25            // Calculate max area histogram for current row heights
26            maxArea = Math.max(maxArea, largestRectangleArea(heights));
27        }
28
29        return maxArea;
30    }
31
32    private int largestRectangleArea(int[] heights) {
33        Deque<Integer> stack = new ArrayDeque<>();
34        int maxArea = 0;
35        int n = heights.length;
36
37        for (int i = 0; i <= n; i++) {
38            int currentHeight = (i == n) ? 0 : heights[i];
39
40            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
41                int height = heights[stack.pop()];
42                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
43                maxArea = Math.max(maxArea, height * width);
44            }
45
46            stack.push(i);
47        }
48
49        return maxArea;
50    }
51}