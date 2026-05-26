import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int orig = image[sr][sc];
        if (orig == color) return image;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == orig) {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        return image;
    }
}