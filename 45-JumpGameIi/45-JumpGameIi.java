// Last updated: 10/1/2026, 10:04:16 AM
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}