// Last updated: 7/17/2026, 9:02:59 AM
class Solution {
    public int divisibleGame(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            for(int d = 2; d * d <= x; d++){
                if(x % d == 0){
                    set.add(d);
                    set.add(x / d);
                }
            }
            if(x > 1) set.add(x);
        }
        set.add(2);
        long bestDiff = Long.MIN_VALUE;
        int bestK = 2;
        for(int k : set){
            long cur = 0;
            long best = Long.MIN_VALUE;
            for(int x : nums){
                if(x % k == 0)
                    cur += x;
                else
                    cur -= x;
                best = Math.max(best, cur);
                if(cur < 0) cur = 0;
            }
            if(best > bestDiff || (best == bestDiff && k < bestK)){
                bestDiff = best;
                bestK = k;
            }
        }
        long ans = (bestDiff % MOD) * bestK % MOD;
        ans = (ans + MOD) % MOD;
        return (int) ans;
    }
}