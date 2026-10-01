// Last updated: 10/1/2026, 9:54:16 AM
class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num == 0)
        {
            return true;
        }
        return num % 10 !=0;
    }
}