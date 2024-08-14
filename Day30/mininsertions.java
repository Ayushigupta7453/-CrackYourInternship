class Solution {
    public int minInsertions(String s) {
        return n = s.length()-lps(s); 
    }
    public int lps(String s){
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        return lcs(s,t);
    }
    public int lcs(String s, String t){
        int n = s.length();
        int m = t.length();
        int ans=0;
        int dp[][]= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(dp[i][j],ans);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}
