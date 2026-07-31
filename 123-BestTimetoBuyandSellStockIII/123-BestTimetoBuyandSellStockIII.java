// Last updated: 7/31/2026, 10:26:20 AM
1class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder sb = new StringBuilder();
4        while (columnNumber > 0) {
5            columnNumber--; 
6            char current = (char) ('A' + (columnNumber % 26));
7            sb.append(current);
8            columnNumber /= 26;
9        }
10        return sb.reverse().toString();
11    }
12}