// Last updated: 7/25/2026, 2:17:38 PM
1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        if (prices == null || prices.length == 0 || k == 0) {
4            return 0;
5        }
6        int n = prices.length;
7        if (k >= n / 2) {
8            int maxProfit = 0;
9            for (int i = 1; i < n; i++) {
10                if (prices[i] > prices[i - 1]) {
11                    maxProfit += prices[i] - prices[i - 1];
12                }
13            }
14            return maxProfit;
15        }
16        int[] buy = new int[k + 1];
17        int[] sell = new int[k + 1];
18        Arrays.fill(buy, Integer.MIN_VALUE);
19        for (int price : prices) {
20            for (int j = 1; j <= k; j++) {
21                buy[j] = Math.max(buy[j], sell[j - 1] - price);
22                sell[j] = Math.max(sell[j], buy[j] + price);
23            }
24        }
25        return sell[k];
26    }
27}