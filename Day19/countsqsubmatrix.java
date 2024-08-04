class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
         int sum =0;
        int dp[][] = new int[m+1][n+1];
       
       for(int i=0;i<n;i++){
        dp[0][i]=matrix[0][i];
        sum +=dp[0][i];
       }
       for(int j=1;j<m;j++){
        dp[j][0]=matrix[j][0];
        sum += dp[j][0];
       }
       
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
               if(matrix[i][j]==1){
                   dp[i][j]= Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
               }
               else{
                dp[i][j]=0;
               }
               sum += dp[i][j];
            }
        }
       return sum;
    }
}
