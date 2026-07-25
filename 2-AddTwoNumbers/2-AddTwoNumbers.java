// Last updated: 7/25/2026, 2:24:26 PM
1class Solution {
2    public List<List<Integer>> getSkyline(int[][] buildings) {
3        List<List<Integer>> result = new ArrayList<>();
4        List<int[]> events = new ArrayList<>();
5        for (int[] b : buildings) {
6            events.add(new int[]{b[0], -b[2]});
7            events.add(new int[]{b[1], b[2]});
8        }
9        Collections.sort(events, (a, b) -> {
10            if (a[0] != b[0]) {
11                return Integer.compare(a[0], b[0]);
12            }
13            return Integer.compare(a[1], b[1]);
14        });
15        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
16        maxHeap.add(0); 
17        int prevMaxHeight = 0;
18        for (int[] event : events) {
19            int x = event[0];
20            int height = event[1];
21            if (height < 0) {
22                maxHeap.add(-height);
23            } else {
24                maxHeap.remove(height);
25            }
26            int currentMaxHeight = maxHeap.peek();
27            if (currentMaxHeight != prevMaxHeight) {
28                List<Integer> point = new ArrayList<>();
29                point.add(x);
30                point.add(currentMaxHeight);
31                result.add(point);
32                prevMaxHeight = currentMaxHeight;
33            }
34        }
35        return result;
36    }
37}