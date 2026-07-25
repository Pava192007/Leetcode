// Last updated: 7/25/2026, 2:28:09 PM
1class Solution {
2    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
3        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
4            return false;
5        }
6        Map<Long, Long> buckets = new HashMap<>();
7        long w = (long) valueDiff + 1; 
8        for (int i = 0; i < nums.length; i++) {
9            long val = (long) nums[i];
10            long bucketId = getBucketId(val, w);
11            if (buckets.containsKey(bucketId)) {
12                return true;
13            }
14            if (buckets.containsKey(bucketId - 1) && Math.abs(val - buckets.get(bucketId - 1)) <= valueDiff) {
15                return true;
16            }
17            if (buckets.containsKey(bucketId + 1) && Math.abs(val - buckets.get(bucketId + 1)) <= valueDiff) {
18                return true;
19            }
20            buckets.put(bucketId, val);
21            if (i >= indexDiff) {
22                long oldBucketId = getBucketId((long) nums[i - indexDiff], w);
23                buckets.remove(oldBucketId);
24            }
25        }
26        return false;
27    }
28    private long getBucketId(long val, long w) {
29        if (val >= 0) {
30            return val / w;
31        } else {
32            return (val + 1) / w - 1; 
33        }
34    }
35}