class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[]=new int[n+1];
       for(int i=0;i<=n;i++){
           dp[i]= Integer.MIN_VALUE;
       }
       dp[0]=0;
       for(int i=1;i<=n;i++){
           if(i-x>=0){
               dp[i]= Math.max(dp[i],dp[i-x]+1);
           }
            if(i-y>=0){
               dp[i]= Math.max(dp[i],dp[i-y]+1);
           }
            if(i-z>=0){
               dp[i]= Math.max(dp[i],dp[i-z]+1);
           }
       }
       if(dp[n]<0){
           return 0;
       }
       return dp[n];
    }
   
}
