class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n <= 1) return 0;
 
        Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));
        
        if (n == 2) return 1;

        int lines = 1; 

        for (int i = 2; i < n; i++) {
            long x1 = stockPrices[i - 2][0];
            long y1 = stockPrices[i - 2][1];
            long x2 = stockPrices[i - 1][0];
            long y2 = stockPrices[i - 1][1];
            long x3 = stockPrices[i][0];
            long y3 = stockPrices[i][1];

            long dx1 = x2 - x1;
            long dy1 = y2 - y1;
            long dx2 = x3 - x2;
            long dy2 = y3 - y2;

            if (dy1 * dx2 != dy2 * dx1) {
                lines++;
            }
        }

        return lines;
    }
}