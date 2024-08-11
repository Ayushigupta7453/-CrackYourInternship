class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        Map<Pair<Integer,Integer>, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(new Pair(i,i),arr[i]);
            for(int j=i+1;j<n;j++){
                mp.put(new Pair(i,j),Math.max(arr[j],mp.get(new Pair(i,j-1))));
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(arr, mp, 0, n - 1, dp);
    }
    private int helper(int arr[], Map<Pair<Integer,Integer>, Integer> mp, int left, int right, int dp[][]){
       if(left == right){
        return 0;
       }
       if(dp[left][right] != -1){
        return dp[left][right];
       }
       int ans = Integer.MAX_VALUE;
       for(int i=left;i<right;i++){
        ans = Math.min(ans,mp.get(new Pair(left,i))*mp.get(new Pair(i+1,right))+helper(arr,mp,left,i,dp)+helper(arr,mp,i+1,right,dp));
       }
       return dp[left][right] = ans;
    }
}
