// Last updated: 10/1/2026, 9:59:23 AM
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(tails, 0, len, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            tails[idx] = num;
            if (idx == len) {
                len++;
            }
        }   
        return len;
    }
}