// Last updated: 7/17/2026, 9:04:50 AM
import java.util.*;

class Solution {

    TreeMap<Integer, List<int[]>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {

            Collections.sort(list, (a, b) -> {

                if (a[0] == b[0])
                    return a[1] - b[1];

                return a[0] - b[0];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] arr : list) {
                temp.add(arr[1]);
            }

            result.add(temp);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col) {

        if (node == null)
            return;

        map.putIfAbsent(col, new ArrayList<>());

        map.get(col).add(new int[]{row, node.val});

        dfs(node.left, row + 1, col - 1);

        dfs(node.right, row + 1, col + 1);
    }
}