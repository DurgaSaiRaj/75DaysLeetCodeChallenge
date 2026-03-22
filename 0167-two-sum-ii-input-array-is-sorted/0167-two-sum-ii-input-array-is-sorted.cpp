class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int lo = 0, hi = numbers.size() - 1;
        while (lo < hi) {
            int s = numbers[lo] + numbers[hi];
            if (s == target) return {lo + 1, hi + 1};
            else if (s < target) lo++;
            else hi--;
        }
        return {};
    }
};