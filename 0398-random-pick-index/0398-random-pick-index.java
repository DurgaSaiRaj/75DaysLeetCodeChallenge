import java.util.Random;
class Solution {
    int[] nums;
    Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) result = i;
            }
        }
        return result;
    }
}