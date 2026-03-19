class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, f0 = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }
        int max = f0, prev = f0;
        for (int k = 1; k < n; k++) {
            // F(k) = F(k-1) + sum - n * nums[n-k]
            int fk = prev + sum - n * nums[n - k];
            max = Math.max(max, fk);
            prev = fk;
        }
        return max;
    }
}