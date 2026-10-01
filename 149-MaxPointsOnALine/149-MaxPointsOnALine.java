// Last updated: 10/1/2026, 10:01:14 AM
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int maxPoints = 1;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeMap = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                double slope;
                if (dx == 0) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (double) dy / dx;
                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                }
                int count = slopeMap.getOrDefault(slope, 1) + 1;
                slopeMap.put(slope, count);
                maxPoints = Math.max(maxPoints, count);
            }
        }
        return maxPoints;
    }
}