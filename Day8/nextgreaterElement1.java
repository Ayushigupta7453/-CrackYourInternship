class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans[]=new int[n];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
       for(int num: nums2){            
            while(!st.isEmpty() && num > st.peek())
                mp.put(st.pop(), num);
            st.push(num);            
        }
        
        int i=0;        
        for(int num : nums1)
            ans[i++] = mp.getOrDefault(num, -1);
        return ans;
    }
}
