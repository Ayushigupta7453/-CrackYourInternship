class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max =0;
        for(int val :dp){
            max = Math.max(max,val);
        }
        return max;
    }
}
