// Last updated: 7/17/2026, 9:06:45 AM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
        {
            return false;
        } 
        while(n % 3 == 0)
        {
            n /= 3;
        }
        return n == 1;
    }
}