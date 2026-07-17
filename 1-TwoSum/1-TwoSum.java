// Last updated: 7/17/2026, 2:48:15 PM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        Map<Integer, Integer> numMap = new HashMap<>();
4        for (int i = 0; i < nums.length; i++) {
5            int complement = target - nums[i];
6            if (numMap.containsKey(complement)) {
7                return new int[] { numMap.get(complement), i };
8            }
9            numMap.put(nums[i], i);
10        }
11        throw new IllegalArgumentException("No two sum solution");
12    }
13}