class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        // Use unsigned right shift to handle negatives (two's complement)
        while (num != 0) {
            sb.append(hex[num & 0xf]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}