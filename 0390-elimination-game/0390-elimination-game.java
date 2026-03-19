class Solution {
    public int lastRemaining(int n) {
        int left = 1, step = 1, remaining = n;
        boolean fromLeft = true;
        while (remaining > 1) {
            if (fromLeft || remaining % 2 == 1) left += step;
            remaining /= 2;
            step *= 2;
            fromLeft = !fromLeft;
        }
        return left;
    }
}