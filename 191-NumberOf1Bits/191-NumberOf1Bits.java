// Last updated: 7/17/2026, 9:08:05 AM
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0)
        {
            n = n &(n-1);
            count++;
        }
        return count;
    }
}