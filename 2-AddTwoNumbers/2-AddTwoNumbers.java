// Last updated: 7/25/2026, 2:23:05 PM
class Solution {
    public String shortestPalindrome(String s) {
        int j = 0,n = s.length();
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == s.charAt(j))
                j++;
        }
        if(j == n)
            return s;
        String suf = s.substring(j);
        String pre = new StringBuilder(suf).reverse().toString();
        return pre + shortestPalindrome(s.substring(0, j)) + suf;
    }
}