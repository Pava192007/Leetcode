// Last updated: 7/17/2026, 9:09:52 AM
import java.util.*;

class Solution {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        String key = s1 + "#" + s2;
        if (memo.containsKey(key))
            return memo.get(key);

        if (!sameChars(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            // Without swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // With swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean sameChars(String a, String b) {

        int[] count = new int[26];

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0)
                return false;
        }

        return true;
    }
}