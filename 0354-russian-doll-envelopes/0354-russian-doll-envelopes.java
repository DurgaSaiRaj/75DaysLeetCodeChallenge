import java.util.Arrays;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] e : envelopes) {
            int h = e[1];
            int lo = 0, hi = len;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (dp[mid] < h) lo = mid + 1;
                else hi = mid;
            }
            dp[lo] = h;
            if (lo == len) len++;
        }
        return len;
    }
}