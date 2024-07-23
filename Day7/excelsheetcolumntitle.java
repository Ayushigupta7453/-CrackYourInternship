class Solution {
    public String convertToTitle(int columnNumber) {
     StringBuilder str = new StringBuilder();
     int n = columnNumber;
     while(n>0){
         --n;
         int d = n%26;
         n=n/26;
         str.append((char)('A'+d));
     }   
     str.reverse();
     return str.toString();
    }
}
