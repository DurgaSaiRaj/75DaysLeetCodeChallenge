import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //1-frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        //2-create buckets
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int num = e.getKey();
            int f = e.getValue();
            buckets[f].add(num);
        }
        //3-collecting numbers
        int[] res = new int[k];
        int idx = 0;
        for (int f = nums.length; f >= 1 && idx < k; f--) {
            for (int num : buckets[f]) {
                res[idx++] = num;
                if (idx == k) break;
            }
        }
        return res;
    }
}
