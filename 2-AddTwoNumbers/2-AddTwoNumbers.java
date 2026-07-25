// Last updated: 7/25/2026, 2:09:34 PM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n = nums.length;
4        int i = n - 2;
5
6        // Step 1: Find the first decreasing element from the right
7        while (i >= 0 && nums[i] >= nums[i + 1]) {
8            i--;
9        }
10
11        // Step 2: If such an element exists, find the element just larger than nums[i] from the right
12        if (i >= 0) {
13            int j = n - 1;
14            while (nums[j] <= nums[i]) {
15                j--;
16            }
17            // Swap nums[i] and nums[j]
18            swap(nums, i, j);
19        }
20
21        // Step 3: Reverse the sequence from i + 1 to the end of the array
22        reverse(nums, i + 1, n - 1);
23    }
24
25    private void swap(int[] nums, int i, int j) {
26        int temp = nums[i];
27        nums[i] = nums[j];
28        nums[j] = temp;
29    }
30
31    private void reverse(int[] nums, int start, int end) {
32        while (start < end) {
33            swap(nums, start, end);
34            start++;
35            end--;
36        }
37    }
38}