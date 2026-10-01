// Last updated: 10/1/2026, 9:54:13 AM
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