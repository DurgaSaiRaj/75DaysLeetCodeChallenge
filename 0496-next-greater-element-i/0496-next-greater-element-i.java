import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int cur = nums2[i];

            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }

            nextGreater.put(cur, stack.isEmpty() ? -1 : stack.peek());
            stack.push(cur);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }
        return ans;
    }
}