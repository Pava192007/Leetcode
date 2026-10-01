// Last updated: 10/1/2026, 10:08:18 AM
1class Solution {
2    public List<Integer> largestDivisibleSubset(int[] nums) {
3        if (nums == null || nums.length == 0) return new ArrayList<>();
4        Arrays.sort(nums);
5        int n = nums.length;
6        int[] dp = new int[n];
7        int[] parent = new int[n];  
8        Arrays.fill(dp, 1);
9        Arrays.fill(parent, -1);
10        int maxSize = 1;
11        int maxIndex = 0;
12        for (int i = 1; i < n; i++) {
13            for (int j = 0; j < i; j++) {
14                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
15                    dp[i] = dp[j] + 1;
16                    parent[i] = j;
17                }
18            }
19            if (dp[i] > maxSize) {
20                maxSize = dp[i];
21                maxIndex = i;
22            }
23        }
24        List<Integer> result = new ArrayList<>();
25        int curr = maxIndex;
26        while (curr != -1) {
27            result.add(nums[curr]);
28            curr = parent[curr];
29        }
30        return result;
31    }
32}