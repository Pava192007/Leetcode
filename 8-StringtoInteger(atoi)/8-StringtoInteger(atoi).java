// Last updated: 8/4/2026, 9:07:34 AM
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0) {
4            return head;
5        }
6        ListNode tail = head;
7        int length = 1;
8        while (tail.next != null) {
9            tail = tail.next;
10            length++;
11        }
12        tail.next = head;
13        k = k % length;
14        int stepsToNewTail = length - k;
15        ListNode newTail = tail;
16        while (stepsToNewTail > 0) {
17            newTail = newTail.next;
18            stepsToNewTail--;
19        }
20        ListNode newHead = newTail.next;
21        newTail.next = null;
22        return newHead;
23    }
24}