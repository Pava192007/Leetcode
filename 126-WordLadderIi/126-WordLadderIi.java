// Last updated: 10/1/2026, 10:01:52 AM
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = steps.get(word);
            if (word.equals(endWord)) break;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char orig = chs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == orig) continue;
                    chs[i] = c;
                    String nextWord = new String(chs);
                    if (dict.contains(nextWord)) {
                        if (!steps.containsKey(nextWord)) {
                            steps.put(nextWord, step + 1);
                            queue.add(nextWord);
                        }
                    }
                }
                chs[i] = orig;
            }
        }
        if (steps.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, steps, path, ans);
        }
        return ans;
    }
    private void dfs(String word, String beginWord, Map<String, Integer> steps, List<String> path, List<List<String>> ans) {
        if (word.equals(beginWord)) {
            List<String> currentPath = new ArrayList<>(path);
            Collections.reverse(currentPath);
            ans.add(currentPath);
            return;
        }
        int currentStep = steps.get(word);
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char orig = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == orig) continue;
                chs[i] = c;
                String prevWord = new String(chs);
                if (steps.containsKey(prevWord) && steps.get(prevWord) == currentStep - 1) {
                    path.add(prevWord);
                    dfs(prevWord, beginWord, steps, path, ans);
                    path.remove(path.size() - 1); 
                }
            }
            chs[i] = orig;
        }
    }
}