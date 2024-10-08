class Solution {
    public int maxCoins(int[] nums) {
       int[] num = new int[nums.length+2];
    num[0] = 1;
    num[num.length-1] = 1;
    int i = 1;
    for(int val : nums)
    {
        num[i] = val;
        i++;
    }
    int L = 0;
    int R = num.length-1;
    return burstballoon(num , L , R , new int[num.length][num.length]);
}
public int burstballoon(int[] num , int l , int r , int[][] dp)
{
    if(l == r-1)
        return 0;
    int ans = 0;
    if(dp[l][r]!=0)
        return dp[l][r];
    for(int i = l + 1 ; i < r ; i++)
    {
        int left = burstballoon(num, l, i , dp);
        int right = burstballoon(num, i, r, dp);
        // int curr = num[i];
        ans = Math.max(ans , left + right + (num[i]*num[l]*num[r]));
    }
    dp[l][r] = ans;
    return ans; 
    }
}
