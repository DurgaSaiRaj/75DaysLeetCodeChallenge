class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int p : piles) {
            if (p > maxPile) maxPile = p;
        }

        int low = 1;
        int high = maxPile;
        int ans = maxPile;

        while (low <= high) {
            int mid = low + (high - low) / 2; // candidate speed k

            if (canFinish(piles, h, mid)) {
                ans = mid;          
                high = mid - 1;
            } else {
                low = mid + 1;      
            }
        }

        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; 

        for (int p : piles) {
           
            hours += (p + k - 1) / k;
            if (hours > h) return false;
        }

        return hours <= h;
    }
}