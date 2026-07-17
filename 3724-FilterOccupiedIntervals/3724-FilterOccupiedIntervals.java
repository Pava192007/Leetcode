// Last updated: 7/17/2026, 9:03:04 AM
class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : occupiedIntervals){
            if(merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1] + 1){
                merged.add(new int[]{interval[0], interval[1]});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] in : merged){
            int l = in[0], r = in[1];
            if(r < freeStart || l > freeEnd){
                ans.add(Arrays.asList(l, r));
            }else{
                if(l < freeStart){
                    ans.add(Arrays.asList(l, freeStart - 1));
                }
                if(r > freeEnd){
                    ans.add(Arrays.asList(freeEnd + 1, r));
                }
            }
        }
        return ans;
    }
}