// Last updated: 7/31/2026, 9:27:33 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int firstBuy = Integer.MIN_VALUE;
4        int firstSell = 0;
5        int secondBuy = Integer.MIN_VALUE;
6        int secondSell = 0;
7        for (int price : prices) {
8            firstBuy = Math.max(firstBuy, -price);
9            firstSell = Math.max(firstSell, firstBuy + price);
10            secondBuy = Math.max(secondBuy, firstSell - price);
11            secondSell = Math.max(secondSell, secondBuy + price);
12        }
13        return secondSell;
14    }
15}