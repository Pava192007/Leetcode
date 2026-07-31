// Last updated: 7/31/2026, 10:18:42 AM
1class Solution {
2    public String reverseWords(String s) {
3        String[] words = s.trim().split("\\s+");
4        StringBuilder result = new StringBuilder();
5        for (int i = words.length - 1; i >= 0; i--) {
6            result.append(words[i]);
7            if (i > 0) {
8                result.append(" ");
9            }
10        }
11        return result.toString();
12    }
13}