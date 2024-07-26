 
     class Solution {
    public int calculate(String s) {
        if(s==null || s.length()== 0) return 0;
        int n = s.length();
        Stack<Integer> st = new Stack<Integer>();
        int curr = 0;
        char op = '+';
        for(int i=0;i<n;i++){
            char currchar = s.charAt(i);
            if(Character.isDigit(currchar)){
                curr = (curr*10) + (currchar - '0');
            }
            if (!Character.isDigit(currchar) && !Character.isWhitespace(currchar) || i == n - 1) {
                if (op == '-') {
                    st.push(-curr);
                }
                else if (op == '+') {
                    st.push(curr);
                }
                else if (op == '*') {
                    st.push(st.pop() * curr);
                }
                else if (op == '/') {
                    st.push(st.pop() / curr);
                }
                op = currchar;
                curr = 0;
            }
        
         }
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}
