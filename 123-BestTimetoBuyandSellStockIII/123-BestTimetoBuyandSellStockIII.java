// Last updated: 7/31/2026, 10:17:08 AM
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
12    public ListNode sortList(ListNode head) {
13        if (head == null || head.next == null) {
14            return head;
15        }
16        ListNode prev = null;
17        ListNode slow = head;
18        ListNode fast = head;
19        while (fast != null && fast.next != null) {
20            prev = slow;
21            slow = slow.next;
22            fast = fast.next.next;
23        }
24        prev.next = null;
25        ListNode left = sortList(head);
26        ListNode right = sortList(slow);
27        return merge(left, right);
28    }
29    private ListNode merge(ListNode l1, ListNode l2) {
30        ListNode dummy = new ListNode(0);
31        ListNode curr = dummy;
32        while (l1 != null && l2 != null) {
33            if (l1.val <= l2.val) {
34                curr.next = l1;
35                l1 = l1.next;
36            } else {
37                curr.next = l2;
38                l2 = l2.next;
39            }
40            curr = curr.next;
41        }
42        if (l1 != null) curr.next = l1;
43        if (l2 != null) curr.next = l2;
44        return dummy.next;
45    }
46}