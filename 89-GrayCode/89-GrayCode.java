// Last updated: 9/22/2026, 9:11:49 AM
1import java.util.ArrayList;
2class Solution {
3    public List<List<String>> groupAnagrams(String[] strs) {
4        if (strs == null || strs.length == 0) {
5            return new ArrayList<>();
6        } 
7        Map<String, List<String>> map = new HashMap<>();
8        for (String str : strs) {
9            char[] charArray = str.toCharArray();
10            Arrays.sort(charArray);
11            String sortedStr = String.valueOf(charArray);
12            if (!map.containsKey(sortedStr)) {
13                map.put(sortedStr, new ArrayList<>());
14            }
15            map.get(sortedStr).add(str);
16        }
17        return new ArrayList<>(map.values());
18    }
19}