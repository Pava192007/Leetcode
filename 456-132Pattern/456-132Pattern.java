// Last updated: 7/17/2026, 9:06:03 AM
class Solution {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;

        // virtual stack pointer
        int top = n;
        int third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] < third) {
                return true;
            }

            // simulate stack pop
            while (top < n && nums[i] > nums[top]) {
                third = nums[top];
                top++;
            }

            // simulate stack push
            top--;
            nums[top] = nums[i];
        }

        return false;
    }
}