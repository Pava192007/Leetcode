// Last updated: 10/1/2026, 10:15:46 AM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        char c = 0;
4        for (char cs : s.toCharArray()) {
5            c ^= cs;
6        }
7        for (char ct : t.toCharArray()) {
8            c ^= ct;
9        }
10        return c;
11    }
12}