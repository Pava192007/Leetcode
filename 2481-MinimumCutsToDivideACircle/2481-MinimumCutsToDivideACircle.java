// Last updated: 10/1/2026, 9:54:09 AM
class Solution {
    public int numberOfCuts(int n) {
        if(n == 1)
        {
            return 0;
        }
        if(n % 2 == 0)
        {
            return n/2;
        }
        else
        {
            return n;
        }
    }
}