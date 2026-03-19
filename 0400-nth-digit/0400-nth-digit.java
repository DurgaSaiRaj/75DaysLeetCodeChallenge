class Solution {
    public int findNthDigit(int n) {
        long digits = 1, count = 9, start = 1;
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }
        long num = start + (n - 1) / digits;
        int digitIndex = (int)((n - 1) % digits);
        return Long.toString(num).charAt(digitIndex) - '0';
    }
}