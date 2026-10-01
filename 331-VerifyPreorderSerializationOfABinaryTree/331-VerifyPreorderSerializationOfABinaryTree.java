// Last updated: 10/1/2026, 9:58:56 AM
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1;
        for (String node : nodes) {
            slots--;
            if (slots < 0) {
                return false;
            }
            if (!node.equals("#")) {
                slots += 2;
            }
        }
        return slots == 0;
    }
}