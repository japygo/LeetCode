class MinStack {
    private final List<Integer> list;
    private final List<Integer> min;

    public MinStack() {
        list = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (min.isEmpty() || val <= min.getLast()) {
            min.add(val);
        }
    }
    
    public void pop() {
        if (list.getLast().equals(min.getLast())) {
            min.removeLast();
        }
        list.removeLast();
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */