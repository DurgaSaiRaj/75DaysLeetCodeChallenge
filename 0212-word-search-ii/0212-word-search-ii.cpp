struct TrieNode {
    TrieNode* ch[26] = {};
    string word = "";
};

class Solution {
    void dfs(vector<vector<char>>& board, TrieNode* node, int i, int j, vector<string>& res) {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size()) return;
        char c = board[i][j];
        if (c == '#' || !node->ch[c-'a']) return;
        node = node->ch[c-'a'];
        if (!node->word.empty()) {
            res.push_back(node->word);
            node->word = "";
        }
        board[i][j] = '#';
        dfs(board, node, i+1, j, res); dfs(board, node, i-1, j, res);
        dfs(board, node, i, j+1, res); dfs(board, node, i, j-1, res);
        board[i][j] = c;
    }
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        TrieNode* root = new TrieNode();
        for (auto& w : words) {
            TrieNode* node = root;
            for (char c : w) {
                if (!node->ch[c-'a']) node->ch[c-'a'] = new TrieNode();
                node = node->ch[c-'a'];
            }
            node->word = w;
        }
        vector<string> res;
        for (int i = 0; i < board.size(); i++)
            for (int j = 0; j < board[0].size(); j++)
                dfs(board, root, i, j, res);
        return res;
    }
};