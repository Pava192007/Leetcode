// Last updated: 7/25/2026, 2:08:16 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode swapPairs(ListNode head) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15        ListNode prev = dummy;
16
17        while (prev.next != null && prev.next.next != null) {
18            ListNode first = prev.next;
19            ListNode second = prev.next.next;
20
21            // Swapping nodes
22            first.next = second.next;
23            second.next = first;
24            prev.next = second;
25
26            // Advance pointer
27            prev = first;
28        }
29
30        return dummy.next;
31    }
32}