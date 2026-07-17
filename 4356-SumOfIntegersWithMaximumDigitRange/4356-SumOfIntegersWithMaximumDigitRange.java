// Last updated: 7/17/2026, 9:02:50 AM
class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;
        for(int num : nums){
            int temp = num;
            int maxDigit = 0;
            int minDigit = 9;
            while(temp > 0){
                int digit = temp % 10;
                maxDigit = Math.max(maxDigit, digit);
                minDigit = Math.min(minDigit, digit);
                temp /= 10;
            }
            maxRange = Math.max(maxRange, maxDigit - minDigit);
        }
        for(int num : nums){
            int temp = num;
            int maxDigit = 0;
            int minDigit = 9;
            while(temp > 0){
                int digit = temp % 10;
                maxDigit = Math.max(maxDigit, digit);
                minDigit = Math.min(minDigit, digit);
                temp /= 10;
            }
            if(maxDigit - minDigit == maxRange){
                sum += num;
            }
        }
        return sum;
    }
}