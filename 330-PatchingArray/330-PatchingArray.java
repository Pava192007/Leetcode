// Last updated: 10/1/2026, 9:58:59 AM
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; 
        int patches = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }
}