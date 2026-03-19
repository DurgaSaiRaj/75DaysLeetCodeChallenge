import java.util.*;
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0), dst = queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) { res[i] = -1.0; continue; }
            res[i] = bfs(graph, src, dst);
        }
        return res;
    }
    private double bfs(Map<String, Map<String, Double>> graph, String src, String dst) {
        if (src.equals(dst)) return 1.0;
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> dist = new HashMap<>();
        queue.offer(src); dist.put(src, 1.0);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (Map.Entry<String, Double> nb : graph.get(cur).entrySet()) {
                if (!dist.containsKey(nb.getKey())) {
                    dist.put(nb.getKey(), dist.get(cur) * nb.getValue());
                    if (nb.getKey().equals(dst)) return dist.get(dst);
                    queue.offer(nb.getKey());
                }
            }
        }
        return -1.0;
    }
}