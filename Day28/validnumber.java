package Day28;

class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        boolean ns = false;
        boolean dot = false;
        boolean ex = false;
        for(int i=0;i<n;i++){
           char ch = s.charAt(i);
           if(Character.isDigit(ch)){
            ns = true;
           }
           else if(ch == '+'|| ch=='-'){
              if(i>0 && (s.charAt(i-1) != 'e'&& s.charAt(i-1) != 'E') ){
                return false;
              }
           }
           else if(ch == '.'){
            if(dot || ex){
                return false;
            }
            dot = true;
           }
           else if(ch=='e'||ch=='E'){
            if(ex || !ns){
                return false;
            }
            ex = true;
            ns = false;
           }
           else{
            return false;
           }
        }
        return ns;
    }
}
