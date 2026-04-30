class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> s(nums.begin(), nums.end());
        int best = 0;
        for (int n : s) {
            if (!s.count(n-1)) {
                int cur = n, len = 1;
                while (s.count(++cur)) len++;
                best = max(best, len);
            }
        }
        return best;
    }
};