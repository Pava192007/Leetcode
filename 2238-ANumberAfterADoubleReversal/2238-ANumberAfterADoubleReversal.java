// Last updated: 7/17/2026, 9:03:19 AM
class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num == 0)
        {
            return true;
        }
        return num % 10 !=0;
    }
}