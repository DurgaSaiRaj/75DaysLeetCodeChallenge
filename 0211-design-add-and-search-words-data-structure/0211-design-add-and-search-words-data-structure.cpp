struct TrieNode {
    TrieNode* ch[26] = {};
    bool isEnd = false;
};

class WordDictionary {
    TrieNode* root;
    bool dfs(TrieNode* node, const string& w, int i) {
        if (i == w.size()) return node->isEnd;
        if (w[i] == '.') {
            for (auto c : node->ch)
                if (c && dfs(c, w, i+1)) return true;
            return false;
        }
        if (!node->ch[w[i]-'a']) return false;
        return dfs(node->ch[w[i]-'a'], w, i+1);
    }
public:
    WordDictionary() { root = new TrieNode(); }
    void addWord(string word) {
        TrieNode* node = root;
        for (char c : word) {
            if (!node->ch[c-'a']) node->ch[c-'a'] = new TrieNode();
            node = node->ch[c-'a'];
        }
        node->isEnd = true;
    }
    bool search(string word) { return dfs(root, word, 0); }
};