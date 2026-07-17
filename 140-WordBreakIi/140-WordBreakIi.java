// Last updated: 7/17/2026, 9:09:11 AM
import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, set, memo);
    }

    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> memo) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> ans = new ArrayList<>();

        if (s.length() == 0) {
            ans.add("");
            return ans;
        }

        for (String word : set) {

            if (s.startsWith(word)) {

                List<String> list = dfs(s.substring(word.length()), set, memo);

                for (String str : list) {
                    if (str.isEmpty())
                        ans.add(word);
                    else
                        ans.add(word + " " + str);
                }
            }
        }

        memo.put(s, ans);
        return ans;
    }
}