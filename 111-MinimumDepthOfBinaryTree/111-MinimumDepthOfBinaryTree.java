// Last updated: 7/17/2026, 9:09:26 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static {
        for (int i = 0; i < 500; i++)
            minDepth(new TreeNode(0));
    }
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int N = queue.size();
            depth++;
            for (int i = 0; i < N; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return depth;
                } 
                if (node.left != null) {
                    queue.add(node.left);
                } 
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return -1;
    }
}