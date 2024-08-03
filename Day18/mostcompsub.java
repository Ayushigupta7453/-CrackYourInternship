class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>nums[i] && (st.size()+n-i)>k){
                st.pop();
            }
            if(st.size()<k){
                st.push(nums[i]);
            }
        }
        int m = st.size();
        int ans[]= new int[m];
        for(int i=m-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}