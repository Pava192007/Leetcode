// Last updated: 7/17/2026, 9:03:16 AM
class Solution 
{
    public int smallestEvenMultiple(int n) 
    {
        if(n % 2 == 0 )
        {
            return n;
        }
        return n * 2;
    }
}