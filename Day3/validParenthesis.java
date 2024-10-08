public class validParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
               st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if(st.isEmpty()){
                    return false;
                }
                else if(s.charAt(i)==')' && st.peek()=='('){
                    st.pop();
                }
                else if(s.charAt(i)=='}' && st.peek()=='{'){
                    st.pop();
                }
                else if(s.charAt(i)==']' && st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
                
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
