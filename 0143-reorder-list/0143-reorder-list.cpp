class Solution {
public:
    void reorderList(ListNode* head) {
        if (!head || !head->next) return;
        // Find middle
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next) { slow = slow->next; fast = fast->next->next; }
        // Reverse second half
        ListNode *prev = nullptr, *cur = slow->next;
        slow->next = nullptr;
        while (cur) { ListNode* nxt = cur->next; cur->next = prev; prev = cur; cur = nxt; }
        // Merge
        ListNode *l1 = head, *l2 = prev;
        while (l2) {
            ListNode *n1 = l1->next, *n2 = l2->next;
            l1->next = l2; l2->next = n1;
            l1 = n1; l2 = n2;
        }
    }
};