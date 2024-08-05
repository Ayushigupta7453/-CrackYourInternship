class Solution {
    public int deleteAndEarn(int[] nums) {
       Arrays.sort(nums);
       List<int[]> l = new ArrayList<>();
       for(int num:nums){
        if(!l.isEmpty() && l.get(l.size()-1)[0] == num){
            l.get(l.size()-1)[1]++;
        }
        else{
            l.add(new int[]{num,1});
        }
       } 
       return solve(l,0,new int[l.size()],l.size());
    }
    private int solve(List<int[]> list, int idx, int[] dp, int n){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int cur = list.get(idx)[0]*list.get(idx)[1];
        int next = solve(list,idx+2,dp,n)+cur;
        int adj = solve(list,idx+1,dp,n);
        if(idx<n-1 && list.get(idx+1)[0]!=list.get(idx)[0]+1){
            adj+=cur;
        }
        dp[idx]=Math.max(adj,next);
        return dp[idx];
    }
}