// Last updated: 7/17/2026, 2:54:25 PM
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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return helper(nums, 0, nums.length - 1);
19    }
20    private TreeNode helper(int[] nums, int left, int right) {
21        if (left > right) {
22            return null;
23        }
24        int mid = left + (right - left) / 2;
25        TreeNode root = new TreeNode(nums[mid]);
26        root.left = helper(nums, left, mid - 1);
27        root.right = helper(nums, mid + 1, right);
28        return root;
29    }
30}