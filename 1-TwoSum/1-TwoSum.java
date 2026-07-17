// Last updated: 7/17/2026, 2:55:52 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isBalanced(TreeNode root) {
18        return checkHeight(root) != -1;
19    }
20    private int checkHeight(TreeNode node) {
21        if (node == null) {
22            return 0;
23        }
24        int leftHeight = checkHeight(node.left);
25        if (leftHeight == -1) {
26            return -1; 
27        }
28        int rightHeight = checkHeight(node.right);
29        if (rightHeight == -1) {
30            return -1; 
31        }
32        if (Math.abs(leftHeight - rightHeight) > 1) {
33            return -1;
34        }
35        return Math.max(leftHeight, rightHeight) + 1;
36    }
37}