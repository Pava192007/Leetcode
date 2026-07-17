// Last updated: 7/17/2026, 9:06:50 AM
import java.util.*;

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        Queue<String> queue =
                new LinkedList<>(Arrays.asList(data.split(",")));

        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {

        String val = queue.poll();

        if (val.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }
}