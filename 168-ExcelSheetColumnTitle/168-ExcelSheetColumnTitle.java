// Last updated: 10/1/2026, 10:00:48 AM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; 
            char current = (char) ('A' + (columnNumber % 26));
            sb.append(current);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}