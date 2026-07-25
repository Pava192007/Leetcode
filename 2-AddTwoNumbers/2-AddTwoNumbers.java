// Last updated: 7/25/2026, 2:10:18 PM
1class Solution {
2    public String countAndSay(int n) {
3        String s = "1";
4        
5        for (int i = 1; i < n; i++) {
6            StringBuilder current = new StringBuilder();
7            int count = 1;
8            
9            for (int j = 0; j < s.length(); j++) {
10                // If the next character is the same, increment count
11                if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
12                    count++;
13                } else {
14                    // Append frequency followed by the character
15                    current.append(count).append(s.charAt(j));
16                    count = 1; // Reset count for the next character group
17                }
18            }
19            
20            s = current.toString();
21        }
22        
23        return s;
24    }
25}