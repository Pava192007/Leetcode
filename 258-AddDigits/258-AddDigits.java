// Last updated: 7/17/2026, 9:07:10 AM
class Solution 
{
    public int addDigits(int num) 
    {
        if (num < 10) return num;  
        int sum = 0;
        while (num > 0) 
        {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);      
    }
}
