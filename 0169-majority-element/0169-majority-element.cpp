class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int cand = nums[0], cnt = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (cnt == 0) { cand = nums[i]; cnt = 1; }
            else if (nums[i] == cand) cnt++;
            else cnt--;
        }
        return cand;
    }
};