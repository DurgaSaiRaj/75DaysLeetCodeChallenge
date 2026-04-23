class Solution {
    int cnt, ans;
    void inorder(TreeNode* node, int k) {
        if (!node) return;
        inorder(node->left, k);
        if (++cnt == k) { ans = node->val; return; }
        inorder(node->right, k);
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        cnt = 0;
        inorder(root, k);
        return ans;
    }
};