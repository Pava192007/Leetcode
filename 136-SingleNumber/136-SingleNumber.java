// Last updated: 7/17/2026, 9:09:14 AM
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums)
        {
            ans ^= n;
        }
        return ans;
    }
}