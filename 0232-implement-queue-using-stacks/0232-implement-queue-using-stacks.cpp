class MyQueue {
    stack<int> in, out;
    void transfer() { while (!in.empty()) { out.push(in.top()); in.pop(); } }
public:
    void push(int x) { in.push(x); }
    int pop() { if (out.empty()) transfer(); int t=out.top(); out.pop(); return t; }
    int peek() { if (out.empty()) transfer(); return out.top(); }
    bool empty() { return in.empty() && out.empty(); }
};