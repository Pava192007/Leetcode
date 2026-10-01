// Last updated: 10/1/2026, 9:34:02 AM
1class Solution {
2    public int minPatches(int[] nums, int n) {
3        long miss = 1; 
4        int patches = 0;
5        int i = 0;
6        while (miss <= n) {
7            if (i < nums.length && nums[i] <= miss) {
8                miss += nums[i];
9                i++;
10            } else {
11                miss += miss;
12                patches++;
13            }
14        }
15        return patches;
16    }
17}