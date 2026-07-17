// Last updated: 7/17/2026, 9:03:02 AM
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        return Math.max(solve(nums, k, true), solve(nums, k, false));
    }
    private long solve(int[] nums, int k, boolean multiply){
        long NEG = Long.MIN_VALUE / 4;
        long noOp = NEG;
        long inOp = NEG;
        long doneOp = NEG;
        long ans = NEG;
        for(int x : nums){
            long val = multiply ? (long) x * k : divide(x, k);
            long newNoOp = Math.max(noOp + x, (long) x);
            long newInOp = Math.max(Math.max(inOp + val, noOp + val), val);
            long newDoneOp = Math.max(Math.max(doneOp + x, inOp + x), x);
            noOp = newNoOp;
            inOp = newInOp;
            doneOp = newDoneOp;
            ans = Math.max(ans, Math.max(inOp, doneOp));
        }
        return ans;
    }
    private long divide(int x, int k){
        if(x >= 0) return x / k;
        return -((-x) / k);
    }
}