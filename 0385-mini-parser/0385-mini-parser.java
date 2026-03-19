import java.util.*;
public class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s));
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger curr = null;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (curr != null) stack.push(curr);
                curr = new NestedInteger();
                start = i + 1;
            } else if (c == ']') {
                if (i > start) curr.add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                if (!stack.isEmpty()) { stack.peek().add(curr); curr = stack.pop(); }
                start = i + 1;
            } else if (c == ',') {
                if (s.charAt(i - 1) != ']') curr.add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                start = i + 1;
            }
        }
        return curr;
    }
}