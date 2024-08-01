class Solution {
    public String removeKdigits(String num, int k) {
         if(num.length() == k){
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            while(!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()){
                k--;
                stack.pop();
            }
            
            stack.push(num.charAt(i));
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, Character.toString(stack.pop()));
        }
        
        String s = sb.toString();
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        
        s = s.substring(i, s.length());
        
        if(s == ""){
            return "0";
        }
        return s; 
    }
}
