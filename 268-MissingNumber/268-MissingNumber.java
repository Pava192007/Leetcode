// Last updated: 7/17/2026, 9:07:05 AM
class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }

        return totalSum - sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 0, 1};
        System.out.println("Missing number: " + sol.missingNumber(nums));
    }
}
