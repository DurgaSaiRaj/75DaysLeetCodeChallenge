import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n], parent = new int[n];
        Arrays.fill(parent, -1);
        int maxLen = 0, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) { maxLen = dp[i]; maxIdx = i; }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = parent[i]) {
            res.add(nums[i]);
            if (parent[i] == -1) break;
        }
        return res;
    }
}