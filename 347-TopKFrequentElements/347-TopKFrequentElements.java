// Last updated: 7/17/2026, 9:06:34 AM
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {

            int maxKey = 0;
            int maxFreq = 0;

            for (int key : map.keySet()) {

                if (map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    maxKey = key;
                }
            }

            result[i] = maxKey;
            map.remove(maxKey);
        }

        return result;
    }
}