// Last updated: 10/1/2026, 10:04:33 AM
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            
            for (int j = 0; j < s.length(); j++) {
                // If the next character is the same, increment count
                if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    // Append frequency followed by the character
                    current.append(count).append(s.charAt(j));
                    count = 1; // Reset count for the next character group
                }
            }
            
            s = current.toString();
        }
        
        return s;
    }
}