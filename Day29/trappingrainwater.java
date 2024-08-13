class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefixheight[]=new int [n];
        int suffixheight[]=new int[n];
        prefixheight[0]=height[0];
        suffixheight[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            prefixheight[i]=Math.max(prefixheight[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            suffixheight[i]=Math.max(suffixheight[i+1],height[i]);
        }
        int amount=0;
        for(int i=1;i<n-1;i++){
            int h1 = prefixheight[i-1];
            int h2 = suffixheight[i+1];
            int d = Math.min(h1,h2);
            if(d>height[i]){
                amount+=(d-height[i]);
            }
        }
        return amount;
    }
}
