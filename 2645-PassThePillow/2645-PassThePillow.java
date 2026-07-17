// Last updated: 7/17/2026, 9:03:12 AM
class Solution {
    public int passThePillow(int n, int time) {
        int cycle = n - 1;
        int rem = time % (2 * cycle);
        if(rem <= cycle)
        {
            return 1 + rem;
        }
        else
        {
            return n - (rem - cycle); 
        }
    }
}