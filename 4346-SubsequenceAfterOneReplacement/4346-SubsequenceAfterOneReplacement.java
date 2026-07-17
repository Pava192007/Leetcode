// Last updated: 7/17/2026, 9:02:48 AM
class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] left = new int[n];
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < m && s.charAt(i) != t.charAt(j)) j++;
            left[i] = j;
            if(j < m) j++;
        }
        if(left[n - 1] < m)
            return true;
        int[] right = new int[n];
        j = m - 1;
        for(int i = n - 1; i >= 0; i--){
            while(j >= 0 && s.charAt(i) != t.charAt(j)) j--;
            right[i] = j;
            if(j >= 0) j--;
        }
        for(int i = 0; i < n; i++){
            int l = (i == 0) ? -1 : left[i - 1];
            int r = (i == n - 1) ? m : right[i + 1];
            if(l + 1 < r)
                return true;
        }
        return false;
    }
}