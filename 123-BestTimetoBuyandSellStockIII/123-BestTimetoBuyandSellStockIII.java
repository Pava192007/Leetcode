// Last updated: 7/31/2026, 10:15:37 AM
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
12    public ListNode insertionSortList(ListNode head) {
13        if (head == null || head.next == null) {
14            return head;
15        }
16        ListNode dummy = new ListNode(0);
17        ListNode curr = head;
18        while (curr != null) {
19            ListNode nextTemp = curr.next;
20            ListNode prev = dummy;
21            while (prev.next != null && prev.next.val < curr.val) {
22                prev = prev.next;
23            }
24            curr.next = prev.next;
25            prev.next = curr;
26            curr = nextTemp;
27        }
28        return dummy.next;
29    }
30}