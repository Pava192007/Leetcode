// Last updated: 7/17/2026, 9:06:56 AM
class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int j = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}