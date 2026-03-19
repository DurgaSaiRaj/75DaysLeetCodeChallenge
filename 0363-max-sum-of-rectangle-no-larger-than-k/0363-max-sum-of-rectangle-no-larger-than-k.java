import java.util.*;
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            int[] rowSum = new int[m];
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) rowSum[i] += matrix[i][r];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                for (int sum : rowSum) {
                    curSum += sum;
                    Integer ceil = set.ceiling(curSum - k);
                    if (ceil != null) ans = Math.max(ans, curSum - ceil);
                    set.add(curSum);
                }
            }
        }
        return ans;
    }
}