// Last updated: 7/31/2026, 10:23:16 AM
1class Solution {
2    public int maximumGap(int[] nums) {
3        if (nums == null || nums.length < 2) {
4            return 0;
5        }
6        int n = nums.length;
7        int minVal = Integer.MAX_VALUE;
8        int maxVal = Integer.MIN_VALUE;
9        for (int num : nums) {
10            minVal = Math.min(minVal, num);
11            maxVal = Math.max(maxVal, num);
12        }
13        if (minVal == maxVal) {
14            return 0;
15        }
16        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
17        int bucketCount = (maxVal - minVal) / bucketSize + 1;
18        int[] bucketMin = new int[bucketCount];
19        int[] bucketMax = new int[bucketCount];
20        Arrays.fill(bucketMin, Integer.MAX_VALUE);
21        Arrays.fill(bucketMax, Integer.MIN_VALUE);
22        for (int num : nums) {
23            int bucketIdx = (num - minVal) / bucketSize;
24            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
25            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
26        }
27        int maxGap = 0;
28        int previousMax = minVal;
29        for (int i = 0; i < bucketCount; i++) {
30            if (bucketMin[i] == Integer.MAX_VALUE) {
31                continue;
32            }
33            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
34            previousMax = bucketMax[i];
35        }
36        return maxGap;
37    }
38}