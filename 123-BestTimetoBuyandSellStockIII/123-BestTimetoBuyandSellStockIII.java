// Last updated: 7/31/2026, 9:35:22 AM
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4        int[] cuts = new int[n];
5        for (int i = 0; i < n; i++) {
6            cuts[i] = i;
7        }
8        for (int i = 0; i < n; i++) {
9            expandAroundCenter(s, i, i, cuts);
10            expandAroundCenter(s, i, i + 1, cuts);
11        }
12        return cuts[n - 1];
13    }
14    private void expandAroundCenter(String s, int left, int right, int[] cuts) {
15        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
16            int currentCut = (left == 0) ? 0 : cuts[left - 1] + 1;
17            cuts[right] = Math.min(cuts[right], currentCut);
18            left--;
19            right++;
20        }
21    }
22}