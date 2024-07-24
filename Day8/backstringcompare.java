class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
       int n1 = s.length();
       int n2 = t.length();
       for(int i=0;i<n1;i++){
        if(s.charAt(i)!='#'){
            s1.push(s.charAt(i));
        }
        else if(!s1.isEmpty()){
            s1.pop();
        }
       }
        for(int i=0;i<n2;i++){
        if(t.charAt(i)!='#'){
            s2.push(t.charAt(i));
        }
        else  if(!s2.isEmpty()){
            s2.pop();
        }
       }
       if(s1.size()!=s2.size()){
        return false;
       }
       while (!s1.isEmpty()) {
            if (s1.peek() != s2.peek()) {
                return false;
            }
            s1.pop();
            s2.pop();
        }
       return true;
    }
}
