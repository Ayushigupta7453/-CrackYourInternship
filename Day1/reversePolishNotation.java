// Evaluate the expression. Return an integer that represents the value of the expression.
class Solution {
    public int evalRPN(String[] tokens) {
     int top = 0;
    int[] stack = new int[tokens.length];
     for(String s :tokens){
        char c = s.charAt(0);
        if(c=='+'){
            int a= stack[--top];
            int b = stack[--top];
            stack[top++]=a+b;
        }
        else if(c=='-' && s.length()==1){
             int a= stack[--top];
            int b = stack[--top];
            stack[top++]=b-a;
        }
        else if(c=='*'){
            int a= stack[--top];
            int b = stack[--top];
            stack[top++]=a*b;
        }
        else if(c=='/'){
            int a= stack[--top];
            int b = stack[--top];
            stack[top++]=b/a;
        }
        else{
             stack[top++] = Integer.parseInt(s);
        }
     }
     return stack[0];
    }
}
