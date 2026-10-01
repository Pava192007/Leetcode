// Last updated: 10/1/2026, 9:54:06 AM
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