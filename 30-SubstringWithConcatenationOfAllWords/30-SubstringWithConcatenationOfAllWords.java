// Last updated: 7/17/2026, 9:10:40 AM
import java.util.AbstractList;

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int id = -1;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        return new AbstractList<Integer>() {
            private List<Integer> res;
            
            @Override
            public Integer get(int index) {
                if (res == null) init();
                return res.get(index);
            }
            
            @Override
            public int size() {
                if (res == null) init();
                return res.size();
            }
            
            private void init() {
                res = new ArrayList<>();
                int wordLen = words[0].length();
                int wordCount = words.length;
                int totalLen = wordLen * wordCount;
                int sLen = s.length();
                
                if (sLen < totalLen) return;
                
                TrieNode root = new TrieNode();
                int numUnique = 0;
                int[] targetCounts = new int[wordCount];
                
                for (String w : words) {
                    TrieNode curr = root;
                    for (int i = 0; i < w.length(); i++) {
                        int idx = w.charAt(i) - 'a';
                        if (curr.children[idx] == null) {
                            curr.children[idx] = new TrieNode();
                        }
                        curr = curr.children[idx];
                    }
                    if (curr.id == -1) {
                        curr.id = numUnique++;
                    }
                    targetCounts[curr.id]++;
                }
                
                int[] sWords = new int[sLen - wordLen + 1];
                for (int i = 0; i <= sLen - wordLen; i++) {
                    TrieNode curr = root;
                    for (int j = 0; j < wordLen; j++) {
                        int idx = s.charAt(i + j) - 'a';
                        curr = curr.children[idx];
                        if (curr == null) break;
                    }
                    sWords[i] = (curr == null) ? -1 : curr.id;
                }
                
                int[] currentCounts = new int[numUnique];
                
                for (int i = 0; i < wordLen; i++) {
                    int left = i;
                    int right = i;
                    int count = 0;
                    
                    Arrays.fill(currentCounts, 0);
                    
                    while (right <= sLen - wordLen) {
                        int id = sWords[right];
                        if (id != -1) {
                            currentCounts[id]++;
                            count++;
                            
                            while (currentCounts[id] > targetCounts[id]) {
                                int leftId = sWords[left];
                                currentCounts[leftId]--;
                                count--;
                                left += wordLen;
                            }
                            
                            if (count == wordCount) {
                                res.add(left);
                            }
                        } else {
                            left = right + wordLen;
                            if (count > 0) {
                                Arrays.fill(currentCounts, 0);
                                count = 0;
                            }
                        }
                        right += wordLen;
                    }
                }
            }
        };
    }
}