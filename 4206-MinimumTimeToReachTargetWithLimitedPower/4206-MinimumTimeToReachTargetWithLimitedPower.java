// Last updated: 7/17/2026, 9:02:52 AM
class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        if(source == target){
            return new long[]{0, power};
        }
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }
        long[][] dist = new long[n][power + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            if (a.time != b.time)
                return Long.compare(a.time, b.time);
            return Integer.compare(b.power, a.power);
        });
        dist[source][power] = 0;
        pq.offer(new State(source, power, 0));
        while (!pq.isEmpty()){
            State cur = pq.poll();
            if(cur.time != dist[cur.node] [cur.power])
                continue;
            if(cur.node == target){
                return new long[]{cur.time, cur.power};
            }
            if(cur.power < cost[cur.node])
                continue;
            int nextPower = cur.power - cost[cur.node];
            for(int[] edge : graph[cur.node]){
                int next = edge[0];
                int t = edge[1];
                long newTime = cur.time + t;
                if(newTime < dist[next][nextPower]){
                    dist[next][nextPower] = newTime;
                    pq.offer(new State(next, nextPower, newTime));
                }
            }
        }
        return new long[]{-1, -1};
    }
    static class State{
        int node;
        int power;
        long time;
        State(int node, int power, long time){
            this.node = node;
            this.power = power;
            this.time = time;
        }
    }
}