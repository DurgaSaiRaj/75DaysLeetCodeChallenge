class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        long long windowSum = 0;
    // Calculate sum of first k elements
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }

    long long maxSum = windowSum;

    // Slide the window across the array
    for (int i = k; i < nums.size(); i++) {
        windowSum += nums[i] - nums[i - k];
        maxSum = max(maxSum, windowSum);
    }

    return (double)maxSum / k;
  
    
    }
};