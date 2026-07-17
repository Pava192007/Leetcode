// Last updated: 7/17/2026, 9:06:00 AM
class Solution {
    public int findComplement(int num) {
        int mask = 0;
        int temp = num;
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        return mask^num;
    }
}