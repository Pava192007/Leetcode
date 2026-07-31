// Last updated: 7/31/2026, 9:38:04 AM
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
12    public void reorderList(ListNode head) {
13        if (head == null || head.next == null) return;
14        ListNode slow = head;
15        ListNode fast = head;
16        while (fast != null && fast.next != null) {
17            slow = slow.next;
18            fast = fast.next.next;
19        }
20        ListNode prev = null;
21        ListNode curr = slow.next;
22        slow.next = null;
23        while (curr != null) {
24            ListNode nextTemp = curr.next;
25            curr.next = prev;
26            prev = curr;
27            curr = nextTemp;
28        }
29        ListNode first = head;
30        ListNode second = prev;
31        while (second != null) {
32            ListNode temp1 = first.next;
33            ListNode temp2 = second.next;
34            first.next = second;
35            second.next = temp1;
36            first = temp1;
37            second = temp2;
38        }
39    }
40}