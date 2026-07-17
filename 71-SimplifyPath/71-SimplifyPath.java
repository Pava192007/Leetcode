// Last updated: 7/17/2026, 9:10:02 AM
class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> seenDir = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                if (sb.isEmpty()) continue;
                
                String currDir = sb.toString();
                sb.setLength(0);

                if (currDir.equals(".")) continue;
                else if (currDir.equals("..")) {
                    seenDir.pollLast();
                }
                else seenDir.addLast(currDir);
            } else sb.append(path.charAt(i));
        }

        StringBuilder normalizedPath = new StringBuilder();
        while (!seenDir.isEmpty()) {
            normalizedPath.append("/").append(seenDir.poll());
        }

        return normalizedPath.isEmpty() ? "/" : normalizedPath.toString();
    }
}