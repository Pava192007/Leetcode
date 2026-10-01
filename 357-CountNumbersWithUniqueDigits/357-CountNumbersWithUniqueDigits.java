// Last updated: 10/1/2026, 9:58:18 AM
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int totalCount = 10; 
        int uniqueDigitsForLength = 9; 
        int availableDigits = 9;
        for (int k = 2; k <= Math.min(n, 10); k++) {
            uniqueDigitsForLength *= availableDigits;
            totalCount += uniqueDigitsForLength;
            availableDigits--;
        }
        return totalCount;
    }
}