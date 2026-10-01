// Last updated: 10/1/2026, 9:59:18 AM
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0, rightRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--; 
                } else {
                    rightRem++; 
                }
            }
        }
        Set<String> resultSet = new HashSet<>();
        backtrack(s, 0, 0, 0, leftRem, rightRem, new StringBuilder(), resultSet);
        return new ArrayList<>(resultSet);
    }
    private void backtrack(String s, int index, int openCount, int closeCount, 
                           int leftRem, int rightRem, StringBuilder path, Set<String> result) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && openCount == closeCount) {
                result.add(path.toString());
            }
            return;
        }
        char currentChar = s.charAt(index);
        int len = path.length();
        if (currentChar == '(' && leftRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem - 1, rightRem, path, result);
        } else if (currentChar == ')' && rightRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem - 1, path, result);
        }
        path.append(currentChar);
        if (currentChar != '(' && currentChar != ')') {
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem, path, result);
        } else if (currentChar == '(') {
            backtrack(s, index + 1, openCount + 1, closeCount, leftRem, rightRem, path, result);
        } else if (currentChar == ')' && openCount > closeCount) {
            backtrack(s, index + 1, openCount, closeCount + 1, leftRem, rightRem, path, result);
        }
        path.setLength(len);
    }
}