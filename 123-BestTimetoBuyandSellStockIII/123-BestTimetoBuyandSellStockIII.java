// Last updated: 7/31/2026, 10:20:41 AM
1class Solution {
2    public int maxProduct(int[] nums) {
3        if (nums == null || nums.length == 0) return 0;
4        int maxSoFar = nums[0];
5        int minSoFar = nums[0];
6        int result = nums[0];
7        for (int i = 1; i < nums.length; i++) {
8            int curr = nums[i];
9            if (curr < 0) {
10                int temp = maxSoFar;
11                maxSoFar = minSoFar;
12                minSoFar = temp;
13            }
14            maxSoFar = Math.max(curr, maxSoFar * curr);
15            minSoFar = Math.min(curr, minSoFar * curr);
16            result = Math.max(result, maxSoFar);
17        }
18        return result;
19    }
20}