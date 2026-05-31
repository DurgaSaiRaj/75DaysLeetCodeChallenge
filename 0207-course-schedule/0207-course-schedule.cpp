class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& prereqs) {
        vector<vector<int>> adj(n);
        vector<int> indegree(n, 0);
        for (auto& p : prereqs) {
            adj[p[1]].push_back(p[0]);
            indegree[p[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) if (!indegree[i]) q.push(i);
        int count = 0;
        while (!q.empty()) {
            int cur = q.front(); q.pop(); count++;
            for (int nb : adj[cur]) if (--indegree[nb] == 0) q.push(nb);
        }
        return count == n;
    }
};