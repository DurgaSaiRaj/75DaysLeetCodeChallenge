import java.util.Random;
class Solution {
    ListNode head;
    Random rand = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int result = 0, i = 1;
        ListNode cur = head;
        while (cur != null) {
            if (rand.nextInt(i) == 0) result = cur.val;
            cur = cur.next;
            i++;
        }
        return result;
    }
}