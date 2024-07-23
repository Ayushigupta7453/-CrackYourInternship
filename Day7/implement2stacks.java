lass twoStacks {
    private int[] arr;
    private int size;
    private int top1;
    private int top2;
    
    twoStacks() {
        size =100;
        arr=new int[100];
        top1 =-1;
        top2 =100;
        
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
         if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } 
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
         if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            return -1; // Stack underflow
        }
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
         if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            return -1; // Stack underflow
        }
    }
}
