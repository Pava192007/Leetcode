// Last updated: 7/25/2026, 2:15:15 PM
1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3        Set<String> wordSet = new HashSet<>(wordList);
4        if (!wordSet.contains(endWord)) {
5            return 0;
6        }
7        Queue<String> queue = new ArrayDeque<>();
8        queue.add(beginWord);
9        int level = 1;
10        while (!queue.isEmpty()) {
11            int size = queue.size();
12            for (int i = 0; i < size; i++) {
13                String currentWord = queue.poll();
14                if (currentWord.equals(endWord)) {
15                    return level;
16                }
17                char[] wordChars = currentWord.toCharArray();
18                for (int j = 0; j < wordChars.length; j++) {
19                    char originalChar = wordChars[j];
20                    for (char c = 'a'; c <= 'z'; c++) {
21                        if (wordChars[j] == c) continue;
22                        wordChars[j] = c;
23                        String newWord = new String(wordChars);
24                        if (wordSet.contains(newWord)) {
25                            queue.add(newWord);
26                            wordSet.remove(newWord);
27                        }
28                    }
29                    wordChars[j] = originalChar; 
30                }
31            }
32            level++;
33        }
34        return 0;
35    }
36}