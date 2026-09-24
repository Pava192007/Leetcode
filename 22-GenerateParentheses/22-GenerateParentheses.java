// Last updated: 9/24/2026, 10:26:40 AM
1class Solution {
2    public int jump(int[] nums) {
3        int jumps = 0;
4        int currentEnd = 0;
5        int maxReach = 0;
6        for (int i = 0; i < nums.length - 1; i++) {
7            maxReach = Math.max(maxReach, i + nums[i]);
8            if (i == currentEnd) {
9                jumps++;
10                currentEnd = maxReach;
11                if (currentEnd >= nums.length - 1) {
12                    break;
13                }
14            }
15        }
16        return jumps;
17    }
18}