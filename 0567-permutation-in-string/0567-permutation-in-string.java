class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            window[s2.charAt(right) - 'a']++;

            while (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if (matches(need, window)) return true;
            right++;
        }

        return false;
    }

    private boolean matches(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) return false;
        }
        return true;
    }
}