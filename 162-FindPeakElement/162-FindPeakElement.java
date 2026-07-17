// Last updated: 7/17/2026, 9:08:50 AM
class Solution 
{
    public int findPeakElement(int[] nums) 
    {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) 
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) 
            {
                right = mid;
            } else 
            {
                left = mid + 1;
            }
        }
        return left;
    }
}
