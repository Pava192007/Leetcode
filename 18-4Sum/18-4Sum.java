// Last updated: 7/31/2026, 8:57:46 AM
1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        Arrays.sort(nums);
5        int n = nums.length;
6        for (int i = 0; i < n - 3; i++) {
7            if (i > 0 && nums[i] == nums[i - 1])
8                continue;
9            for (int j = i + 1; j < n - 2; j++) {
10                if (j > i + 1 && nums[j] == nums[j - 1])
11                    continue;
12                int left = j + 1;
13                int right = n - 1;
14                while (left < right) {
15                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
16                    if (sum == target) {
17                        result.add(Arrays.asList(
18                                nums[i],
19                                nums[j],
20                                nums[left],
21                                nums[right]
22                        ));
23                        left++;
24                        right--;
25                        while (left < right && nums[left] == nums[left - 1])
26                            left++;
27                        while (left < right && nums[right] == nums[right + 1])
28                            right--;
29                    } else if (sum < target) {
30                        left++;
31                    } else {
32                        right--;
33                    }
34                }
35            }
36        }
37        return result;
38    }
39}