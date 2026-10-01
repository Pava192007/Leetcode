// Last updated: 10/1/2026, 10:01:42 AM
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }
        for (int i = 0; i < n; i++) {
            expandAroundCenter(s, i, i, cuts);
            expandAroundCenter(s, i, i + 1, cuts);
        }
        return cuts[n - 1];
    }
    private void expandAroundCenter(String s, int left, int right, int[] cuts) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int currentCut = (left == 0) ? 0 : cuts[left - 1] + 1;
            cuts[right] = Math.min(cuts[right], currentCut);
            left--;
            right++;
        }
    }
}