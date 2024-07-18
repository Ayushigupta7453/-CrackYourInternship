// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans =0;
        int n = heights.length;
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[st.peek()]>heights[i]){
                int ind = st.pop();
                ans = Math.max(ans, heights[ind]*(i-st.peek()-1));
            }
            st.push(i);
        }
        int right = n;
        while(st.peek()!=-1){
            int ind = st.pop();
                ans = Math.max(ans, heights[ind]*(right-st.peek()-1));
        }
        return ans;
    }
}
