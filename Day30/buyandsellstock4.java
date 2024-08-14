
class Solution {
    public int maxProfit(int k, int[] prices) {
        int sell[]= new int[k];
        int buy[]=new int[k];
        for(int i=0;i<k;i++){
            sell[i]=0;
            buy[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<k;j++){
                int initial =j == 0?0:sell[j-1];
                buy[j]=Math.max(buy[j],initial-prices[i]);
                sell[j]=Math.max(sell[j],buy[j]+prices[i]);
            }
        }
        return sell[k-1];
    }
}