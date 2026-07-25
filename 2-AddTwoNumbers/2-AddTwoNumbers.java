// Last updated: 7/25/2026, 2:16:33 PM
1class Solution {
2    public int maxPoints(int[][] points) {
3        int n = points.length;
4        if (n <= 2) {
5            return n;
6        }
7        int maxPoints = 1;
8        for (int i = 0; i < n; i++) {
9            Map<Double, Integer> slopeMap = new HashMap<>();
10            for (int j = i + 1; j < n; j++) {
11                int dx = points[j][0] - points[i][0];
12                int dy = points[j][1] - points[i][1];
13                double slope;
14                if (dx == 0) {
15                    slope = Double.POSITIVE_INFINITY;
16                } else {
17                    slope = (double) dy / dx;
18                    if (slope == -0.0) {
19                        slope = 0.0;
20                    }
21                }
22                int count = slopeMap.getOrDefault(slope, 1) + 1;
23                slopeMap.put(slope, count);
24                maxPoints = Math.max(maxPoints, count);
25            }
26        }
27        return maxPoints;
28    }
29}