import java.util.Random;
class Solution {
    int[] orig, arr;
    Random rand = new Random();

    public Solution(int[] nums) {
        orig = nums.clone();
        arr = nums.clone();
    }

    public int[] reset() {
        arr = orig.clone();
        return arr;
    }

    public int[] shuffle() {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
        return arr;
    }
}