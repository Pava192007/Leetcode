// Last updated: 10/1/2026, 9:47:14 AM
1import java.util.*;
2
3/**
4 * // This is the interface that allows for creating nested lists.
5 * // You should not implement it, or speculate about its implementation
6 * public interface NestedInteger {
7 *
8 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
9 *     public boolean isInteger();
10 *
11 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
12 *     // Return null if this NestedInteger holds a nested list
13 *     public Integer getInteger();
14 *
15 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
16 *     // Return null if this NestedInteger holds a single integer
17 *     public List<NestedInteger> getList();
18 * }
19 */
20public class NestedIterator implements Iterator<Integer> {
21    private Deque<NestedInteger> stack;
22
23    public NestedIterator(List<NestedInteger> nestedList) {
24        stack = new ArrayDeque<>();
25        // Push all elements onto stack in reverse order so the first element is on top
26        for (int i = nestedList.size() - 1; i >= 0; i--) {
27            stack.push(nestedList.get(i));
28        }
29    }
30
31    @Override
32    public Integer next() {
33        // hasNext() guarantees the top element is a single integer
34        return stack.pop().getInteger();
35    }
36
37    @Override
38    public boolean hasNext() {
39        while (!stack.isEmpty()) {
40            NestedInteger curr = stack.peek();
41            if (curr.isInteger()) {
42                return true;
43            }
44            
45            // Pop the list and push its elements in reverse order
46            stack.pop();
47            List<NestedInteger> list = curr.getList();
48            for (int i = list.size() - 1; i >= 0; i--) {
49                stack.push(list.get(i));
50            }
51        }
52        return false;
53    }
54}
55
56/**
57 * Your NestedIterator object will be instantiated and called as such:
58 * NestedIterator i = new NestedIterator(nestedList);
59 * while (i.hasNext()) v[f()] = i.next();
60 */