class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxCount = Math.max(maxCount, freq[idx]);
            while ((right - left + 1) - maxCount > k) {
                int leftIdx = s.charAt(left) - 'A';
                freq[leftIdx]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}