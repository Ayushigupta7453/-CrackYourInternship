class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][]=new int[m][n];
        
        for(int i= m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j== n-1){
                   dp[i][j]=grid[i][j];
                   continue;
                }
                
                    int right=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
                    if(j+1<n){
                        right = dp[i][j+1];
                    }
                    if(i+1<m){
                        down = dp[i+1][j];
                    }
                    dp[i][j]= (int)Math.min(right,down)+grid[i][j];
                
            }
        }
        return dp[0][0];
    }
}
