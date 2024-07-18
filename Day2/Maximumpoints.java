class Solution {
    public int maxScore(int[] cardpoints, int k) {
        int n = cardpoints.length;
        int sum=0;
        for(int i: cardpoints){
            sum+= i;
        }
        int minsum = 0;
        for(int i=0;i<(n-k);i++){
            minsum+=cardpoints[i];
        }
        int currsum = minsum;
        for(int i=n-k;i<n;i++){
            currsum = currsum+ cardpoints[i]-cardpoints[i-(n-k)];
            minsum = Math.min(minsum,currsum);
        }
        return sum - minsum;
        
    }
}
