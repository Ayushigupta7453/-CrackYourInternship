class Solution {
    public String reverseWords(String s) {
        Stack<StringBuilder> q = new Stack<>();
        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder("");
            while(i<s.length() && s.charAt(i)!=' '){
                 sb.append(s.charAt(i));
                 i++;
            }
            if(sb.length()>0){
                q.push(sb);
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(q.size()>1){
            ans.append(q.pop());
            ans.append(" ");
        }
        ans.append(q.pop());

        return ans.toString();
    }
}
