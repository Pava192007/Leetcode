// Last updated: 7/31/2026, 9:36:53 AM
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int[] candies = new int[n];
5        Arrays.fill(candies, 1);
6        for (int i = 1; i < n; i++) {
7            if (ratings[i] > ratings[i - 1]) {
8                candies[i] = candies[i - 1] + 1;
9            }
10        }
11        for (int i = n - 2; i >= 0; i--) {
12            if (ratings[i] > ratings[i + 1]) {
13                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
14            }
15        }
16        int totalCandies = 0;
17        for (int count : candies) {
18            totalCandies += count;
19        }
20        return totalCandies;
21    }
22}