// Last updated: 7/31/2026, 9:30:09 AM
1class Solution {
2    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
3        List<List<String>> ans = new ArrayList<>();
4        Set<String> dict = new HashSet<>(wordList);
5        if (!dict.contains(endWord)) {
6            return ans;
7        }
8        Map<String, Integer> steps = new HashMap<>();
9        steps.put(beginWord, 0);
10        Queue<String> queue = new LinkedList<>();
11        queue.add(beginWord);
12        while (!queue.isEmpty()) {
13            String word = queue.poll();
14            int step = steps.get(word);
15            if (word.equals(endWord)) break;
16            char[] chs = word.toCharArray();
17            for (int i = 0; i < chs.length; i++) {
18                char orig = chs[i];
19                for (char c = 'a'; c <= 'z'; c++) {
20                    if (c == orig) continue;
21                    chs[i] = c;
22                    String nextWord = new String(chs);
23                    if (dict.contains(nextWord)) {
24                        if (!steps.containsKey(nextWord)) {
25                            steps.put(nextWord, step + 1);
26                            queue.add(nextWord);
27                        }
28                    }
29                }
30                chs[i] = orig;
31            }
32        }
33        if (steps.containsKey(endWord)) {
34            List<String> path = new ArrayList<>();
35            path.add(endWord);
36            dfs(endWord, beginWord, steps, path, ans);
37        }
38        return ans;
39    }
40    private void dfs(String word, String beginWord, Map<String, Integer> steps, List<String> path, List<List<String>> ans) {
41        if (word.equals(beginWord)) {
42            List<String> currentPath = new ArrayList<>(path);
43            Collections.reverse(currentPath);
44            ans.add(currentPath);
45            return;
46        }
47        int currentStep = steps.get(word);
48        char[] chs = word.toCharArray();
49        for (int i = 0; i < chs.length; i++) {
50            char orig = chs[i];
51            for (char c = 'a'; c <= 'z'; c++) {
52                if (c == orig) continue;
53                chs[i] = c;
54                String prevWord = new String(chs);
55                if (steps.containsKey(prevWord) && steps.get(prevWord) == currentStep - 1) {
56                    path.add(prevWord);
57                    dfs(prevWord, beginWord, steps, path, ans);
58                    path.remove(path.size() - 1); 
59                }
60            }
61            chs[i] = orig;
62        }
63    }
64}