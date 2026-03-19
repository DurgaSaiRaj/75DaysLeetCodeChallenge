class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] stack = new int[lines.length + 1];
        int maxLen = 0;
        for (String line : lines) {
            int depth = 0;
            while (depth < line.length() && line.charAt(depth) == '\t') depth++;
            String name = line.substring(depth);
            int curLen = stack[depth] + name.length() + 1;
            stack[depth + 1] = curLen;
            if (name.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }
}