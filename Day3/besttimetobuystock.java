class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int maxprofit = 0;
        for(int i=1;i<n;i++){
            if(buy>prices[i]){
                buy = prices[i];
            }
            else if(prices[i]-buy>maxprofit){
                maxprofit = prices[i]-buy;
            }
        }
        return maxprofit;
    }
}
