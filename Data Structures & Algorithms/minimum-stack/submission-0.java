class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty() || val<=minstack.peek())
            minstack.push(val);
    }
    
    public void pop() {
        int poppedvalue=stack.pop();
        if(poppedvalue==minstack.peek() && !minstack.isEmpty()){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
