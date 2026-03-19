class Solution {
    public boolean validUtf8(int[] data) {
        int continuationBytes = 0;
        for (int d : data) {
            d = d & 0xFF;
            if (continuationBytes > 0) {
                // Must be 10xxxxxx
                if ((d >> 6) != 2) return false;
                continuationBytes--;
            } else {
                // Determine number of bytes in this character
                if ((d >> 7) == 0) {
                    continuationBytes = 0; // 1-byte: 0xxxxxxx
                } else if ((d >> 5) == 0b110) {
                    continuationBytes = 1; // 2-byte: 110xxxxx
                } else if ((d >> 4) == 0b1110) {
                    continuationBytes = 2; // 3-byte: 1110xxxx
                } else if ((d >> 3) == 0b11110) {
                    continuationBytes = 3; // 4-byte: 11110xxx
                } else {
                    return false;
                }
            }
        }
        return continuationBytes == 0;
    }
}