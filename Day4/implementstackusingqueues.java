class MyStack {
    Queue<Integer> q;
    Queue<Integer> tmp;

    public MyStack() {
        q = new LinkedList<>();
        tmp = new LinkedList<>();
    }
    
    public void push(int x) {
        if(q.size()==0){
            q.add(x);
        }
        else{
            int l = q.size();
            for(int i=0;i<l;i++){
                tmp.add(q.remove());
            }
            q.add(x);
            for(int i=0;i<l;i++){
                q.add(tmp.remove());
            }
        }
    }
    
    public int pop() {
      return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
