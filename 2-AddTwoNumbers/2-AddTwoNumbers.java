// Last updated: 7/25/2026, 2:22:25 PM
1class Solution {
2    public String shortestPalindrome(String s) {
3        if (s == null || s.length() <= 1) {
4            return s;
5        }
6        String reversed = new StringBuilder(s).reverse().toString();
7        String temp = s + "#" + reversed;
8        int[] lps = new int[temp.length()];
9        for (int i = 1; i < temp.length(); i++) {
10            int j = lps[i - 1];
11            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
12                j = lps[j - 1];
13            }
14            if (temp.charAt(i) == temp.charAt(j)) {
15                j++;
16            }
17            lps[i] = j;
18        }
19        int longestPalindromePrefixLength = lps[temp.length() - 1];
20        String suffixToAppend = reversed.substring(0, s.length() - longestPalindromePrefixLength);
21        return suffixToAppend + s;
22    }
23}