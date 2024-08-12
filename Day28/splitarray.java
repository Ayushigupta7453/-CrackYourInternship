class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int r =0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            r += nums[i];
            l = Math.max(l,nums[i]);
        }
        while(l<=r){
            int mid = (l+r)/2;
            if(check(nums,k,mid)){
                res= mid;
                r = mid-1;
            }
            else{
              l =mid +1;
            }
        }
        return res;
    }
    public boolean check(int nums[], int k,int mid){
        int count =1;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+sum>mid){
                count++;
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        return count <=k;
    }
}
