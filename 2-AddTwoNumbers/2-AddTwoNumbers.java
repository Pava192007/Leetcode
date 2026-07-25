// Last updated: 7/25/2026, 2:02:58 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxLength = 0;
4        int left = 0;
5        Map<Character, Integer> map = new HashMap<>();
6        for (int right = 0; right < s.length(); right++) {
7            char currentChar = s.charAt(right);
8            if (map.containsKey(currentChar)) {
9                left = Math.max(left, map.get(currentChar) + 1);
10            }
11            map.put(currentChar, right);
12            maxLength = Math.max(maxLength, right - left + 1);
13        }
14        return maxLength;
15    }
16}