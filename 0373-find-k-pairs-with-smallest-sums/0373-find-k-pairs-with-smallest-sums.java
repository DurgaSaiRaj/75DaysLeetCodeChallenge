import java.util.*;
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) pq.offer(new int[]{i, 0});
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (cur[1] + 1 < nums2.length) pq.offer(new int[]{cur[0], cur[1] + 1});
        }
        return res;
    }
}