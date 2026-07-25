// Last updated: 7/25/2026, 2:34:14 PM
1class Solution {
2    public int calculate(String s) {
3        Deque<Integer> stack = new ArrayDeque<>();
4        int currentNumber = 0;
5        int result = 0;
6        int sign = 1; 
7        for (int i = 0; i < s.length(); i++) {
8            char ch = s.charAt(i);
9            if (Character.isDigit(ch)) {
10                currentNumber = currentNumber * 10 + (ch - '0');
11            } else if (ch == '+') {
12                result += sign * currentNumber;
13                currentNumber = 0;
14                sign = 1;
15            } else if (ch == '-') {
16                result += sign * currentNumber;
17                currentNumber = 0;
18                sign = -1;
19            } else if (ch == '(') {
20                stack.push(result);
21                stack.push(sign);
22                result = 0;
23                sign = 1;
24            } else if (ch == ')') {
25                result += sign * currentNumber;
26                currentNumber = 0;
27                result *= stack.pop(); 
28                result += stack.pop(); 
29            }
30        }
31        return result + (sign * currentNumber);
32    }
33}