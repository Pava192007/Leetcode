// Last updated: 7/25/2026, 2:06:14 PM
1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3        Arrays.sort(nums);
4        int closestSum = nums[0] + nums[1] + nums[2];
5        for (int i = 0; i < nums.length - 2; i++) {
6            int left = i + 1;
7            int right = nums.length - 1;
8            while (left < right) {
9                int currentSum = nums[i] + nums[left] + nums[right];
10                if (currentSum == target) {
11                    return currentSum;
12                }
13                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
14                    closestSum = currentSum;
15                }
16                if (currentSum < target) {
17                    left++;
18                } else {
19                    right--;
20                }
21            }
22        }
23        return closestSum;
24    }
25}