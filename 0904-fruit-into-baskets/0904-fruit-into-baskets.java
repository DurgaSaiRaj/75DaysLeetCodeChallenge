import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
           
            int f = fruits[right];
            count.put(f, count.getOrDefault(f, 0) + 1);

      
            while (count.size() > 2) {
                int lf = fruits[left];
                count.put(lf, count.get(lf) - 1);
                if (count.get(lf) == 0) {
                    count.remove(lf);
                }
                left++;
            }

           
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}