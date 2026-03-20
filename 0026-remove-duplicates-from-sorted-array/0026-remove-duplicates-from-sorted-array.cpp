class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;

        int uniquePos = 0; // Index to place the next unique element
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[uniquePos]) {
                uniquePos++;
                nums[uniquePos] = nums[i];
            }
        }
        return uniquePos + 1;
        
    }
};