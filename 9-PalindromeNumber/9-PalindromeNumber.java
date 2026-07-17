// Last updated: 7/17/2026, 9:11:12 AM
class Solution 
{
    public boolean isPalindrome(int x) 
    {
        if(x < 0)
        {
            return false;
        }
        int original = x;
        int reversed = 0;
        while(x != 0)
        {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }
}